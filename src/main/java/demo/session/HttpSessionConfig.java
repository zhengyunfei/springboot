package demo.session;


/**
 * 会话信息保存到redis定义，头信息保存
 * 
 * @author jiekechoo
 *
 */
// 暂停回话保存在redis（2015.6.11）
//@Configuration
//@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 3600)
//public class HttpSessionConfig {
//
//	/**
//	 * 定义Jedis连接工厂
//	 * 
//	 * @return factory
//	 */
//	@Bean
//	public JedisConnectionFactory connectionFactory() {
//		JedisConnectionFactory factory = new JedisConnectionFactory();
//		return factory;
//	}
//
//	 暂时取消 x-auth-token，以默认cookie代替
//	 /**
//	 * HttpSessionStrategy
//	 *
//	 * @return
//	 */
//	 @Bean
//	 public HttpSessionStrategy httpSessionStrategy() {
//	 return new HeaderHttpSessionStrategy();
//	 }
//
// }
