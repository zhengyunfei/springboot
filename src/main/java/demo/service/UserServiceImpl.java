package demo.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import demo.domain.Authority;
import demo.domain.User;
import demo.domain.UserCreateForm;
import demo.repository.AuthorityRepository;
import demo.repository.UserRepository;

/**
 * 用户服务接口实现
 * 
 * @author jiekechoo
 *
 */
@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(UserServiceImpl.class);
	private final UserRepository userRepository;
	private final AuthorityRepository authorityRepository;

	@Autowired
	private Environment env;

	/**
	 * 装载userRepository
	 * 
	 * @param userRepository
	 */
	@Autowired
	public UserServiceImpl(UserRepository userRepository,
			AuthorityRepository authorityRepository) {
		this.userRepository = userRepository;
		this.authorityRepository = authorityRepository;
	}

	/**
	 * 查找用户名
	 */
	@Override
	public User getUserByUsername(String username) {
		LOGGER.debug("Getting user by username={}", username);
		return userRepository.findByUsername(username);
	}

	/**
	 * 创建新用户
	 */
	@Override
	public User create(UserCreateForm form) {
		User user = new User();
		user.setUsername(form.getUsername());
		user.setPassword(new BCryptPasswordEncoder(10).encode(form
				.getPassword()));
		user.setEnabled(1);

		Authority authority = new Authority();
		authority.setUsername(form.getUsername());
		authority.setAuthority("ROLE_USER");
		authorityRepository.save(authority);

		// System.out.println(form);
		return userRepository.save(user);
	}

	@Override
	public Object uploadImage(MultipartFile file, HttpServletRequest request) {
		User user = getCurrentUser();
		HashMap<String, Object> ret = new HashMap<String, Object>();
		if (file != null) {
			if (!file.isEmpty()) {
				try {
					byte[] bytes = file.getBytes();

					// 当前app根目录
					String rootPath = request.getServletContext().getRealPath(
							"/");

					// 需要上传的相对地址（application.properties中获取）
					String relativePath = env
							.getProperty("image.file.upload.dir");

					// 文件夹是否存在，不存在就创建
					File dir = new File(rootPath + File.separator
							+ relativePath);
					if (!dir.exists())
						dir.mkdirs();
					String fileExtension = getFileExtension(file);

					// 生成UUID样式的文件名
					String filename = java.util.UUID.randomUUID().toString()
							+ "." + fileExtension;

					// 文件全名
					String fullFilename = dir.getAbsolutePath()
							+ File.separator + filename;

					// 用户头像被访问路径
					String relativeFile = relativePath + File.separator
							+ filename;

					// 保存图片
					File serverFile = new File(fullFilename);
					BufferedOutputStream stream = new BufferedOutputStream(
							new FileOutputStream(serverFile));
					stream.write(bytes);
					stream.close();
					LOGGER.info("Server File Location = "
							+ serverFile.getAbsolutePath());

					String serverPath = new URL(request.getScheme(),
							request.getServerName(), request.getServerPort(),
							request.getContextPath()).toString();
					ret.put("url", serverPath + "/" + relativeFile);

					user.setImage(relativeFile);
					userRepository.save(user);

				} catch (Exception e) {
					LOGGER.info("error: {}", e);
					ret.put("url", "none");
				}
			}
		}
		return null;
	}

	/**
	 * 返回文件后缀名，如果有的话
	 */
	public static String getFileExtension(MultipartFile file) {
		if (file == null) {
			return null;
		}

		String name = file.getOriginalFilename();
		int extIndex = name.lastIndexOf(".");

		if (extIndex == -1) {
			return "";
		} else {
			return name.substring(extIndex + 1);
		}
	}

	/**
	 * 获取当前登录用户名称
	 */
	@Override
	public String getCurrentUsername() {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String name = auth.getName();
		return name;
	}

	/**
	 * 获取当前用户实例
	 */
	@Override
	public User getCurrentUser() {
		return userRepository.findByUsername(getCurrentUsername());
	}

	@Override
	public Object listAllUsers(Pageable p) {
		Page<User> users = userRepository.findAll(p);
		return users;
	}

	@Override
	public Object getUserList(int current, int rowCount, String searchPhrase) {
		HashMap<String, Object> ret = new HashMap<String, Object>();
		ArrayList<Object> pList = new ArrayList<Object>();
		Long total = userRepository.count();
		int i = 0;

		if (rowCount == -1) {
			rowCount = new Long(total).intValue();
		}
		Page<User> users = userRepository.findByUsernameContaining(
				searchPhrase, new PageRequest(current - 1, rowCount));
		for (User user : users) {
			HashMap<String, Object> data = new HashMap<String, Object>();
			data.put("id", user.getId());
			data.put("username", user.getUsername());
			data.put("image", user.getImage());
			if (user.getEnabled() == 1) {
				data.put("enabled", "<font color='green'>启用</font>");
			} else {
				data.put("enabled", "<font color='red'>禁用</font>");
			}

			List<Authority> authorities = authorityRepository
					.findByUsername(user.getUsername());
			ArrayList<String> arrayList = new ArrayList<String>();
			for (Authority authority : authorities) {
				if (authority.getAuthority().equals("ROLE_ADMIN")) {
					arrayList.add("管理员");
				} else if (authority.getAuthority().equals("ROLE_USER")) {
					arrayList.add("用户");
				}
			}
			data.put("role", arrayList.toString());
			pList.add(data);
			i++;
		}

		ret.put("current", 1);
		ret.put("rowCount", i);
		ret.put("rows", pList);
		ret.put("total", total);

		return ret;
	}
}
