/*
*       Developed by Justin Mead
*       Copyright (c) 2011 MeadMiracle
*       www.meadmiracle.com / meadmiracle@gmail.com
*       Licensed under the MIT License http://opensource.org/licenses/MIT
*
*       Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), 
*       to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or 
*       sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
*       The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
*       THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
*       FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, 
*       WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*
*       As this Dual Listbox jQuery Plug-in was initially released with GPL v2 License which was quite restrictive, I got the following explicit permission 
*       to release it under MIT License from the original author and copyright holder.
*       From: Justin Mead <xxxxxxxxxxx@gmail.com>
*       Date: December 19, 2012, 4:11:28 PM PST
*       To: Parvez <xxxxxxxxxxx@gmail.com>
*       Cc: web@meadmiracle.com
*       Subject: Re: Dual Listbox jQuery Plug-in
*       Happy to help!  You have my permission to release my code under the MIT license.  Good luck with your project!
*       Justin
*
*       Version 1.3
*       Testing: IE8/Windows XP
*                Firefox/Windows XP
*                Chrome/Windows XP
*
*       OPTIONS LISTING:
*           *box1View, box2View         - the id attributes of the VISIBLE listboxes
*           *box1Storage, box2Storage   - the id attributes of the HIDDEN listboxes (used for filtering)
*           *box1Filter, box2Filter     - the id attributes of the textboxes used to filter the lists
*           *box1Clear, box2Clear       - the id attributes of the elements used to clear/reset the filters
*           *box1Counter, box2Counter   - the id attributes of the elements used to display counts of visible/total items (used when filtering)
*           *to1, to2                   - the id attributes of the elements used to transfer only selected items between boxes
*           *allTo1, allTo2             - the id attributes of the elements used to transfer ALL (visible) items between boxes
*           *transferMode               - the type of transfer to perform on items (see heading TRANSFER MODES)
*           *sortBy                     - the attribute to use when sorting items (values: 'text' or 'value')
*           *useFilters                 - allow the filtering of items in either box (true/false)
*           *useCounters                - use the visible/total counters (true/false)
*           *useSorting                 - sort items after executing a transfer (true/false)
*           *selectOnSubmit             - select items in box 2 when the form is submitted (true/false)
*
*       All options have default values, and as such, are optional.  Check the 'settings' JSON object below to see the defaults.
*
*       TRANSFER MODES:
*           * 'move' - In this mode, items will be removed from the box in which they currently reside and moved to the other box. This is the default.
*           * 'copy' - In this mode, items in box 1 will ALWAYS remain in box 1 (unless they are hidden by filtering).  When they are selected for transfer
*                      they will be copied to box 2 and will be given the class 'copiedOption' in box 1 (my default styling for this class is yellow background
*                      but you may choose whatever styling suits you).  If they are then transferred from box 2, they disappear from box 2, and the 'copiedOption'
*                      class is removed from the corresponding option in box 1.
*
*/

(function($) {
    var settings = new Array();
    var group1 = new Array();
    var group2 = new Array();
    var onSort = new Array();

    //the main method that the end user will execute to setup the DLB
    $.configureBoxes = function(options) {
        //define default settings
        var index = settings.push({
            box1View: 'box1View',
            box1Storage: 'box1Storage',
            box1Filter: 'box1Filter',
            box1Clear: 'box1Clear',
            box1Counter: 'box1Counter',
            box2View: 'box2View',
            box2Storage: 'box2Storage',
            box2Filter: 'box2Filter',
            box2Clear: 'box2Clear',
            box2Counter: 'box2Counter',
            to1: 'to1',
            allTo1: 'allTo1',
            to2: 'to2',
            allTo2: 'allTo2',
            transferMode: 'move',
            sortBy: 'text',
            useFilters: true,
            useCounters: true,
            useSorting: true,
            selectOnSubmit: true
        });

        index--;

        //merge default settings w/ user defined settings (with user-defined settings overriding defaults)
        $.extend(settings[index], options);

        //define box groups
        group1.push({
            view: settings[index].box1View,
            storage: settings[index].box1Storage,
            filter: settings[index].box1Filter,
            clear: settings[index].box1Clear,
            counter: settings[index].box1Counter,
            index: index
        });
        group2.push({
            view: settings[index].box2View,
            storage: settings[index].box2Storage,
            filter: settings[index].box2Filter,
            clear: settings[index].box2Clear,
            counter: settings[index].box2Counter,
            index: index
        });

        //define sort function
        if (settings[index].sortBy == 'text') {
            onSort.push(function(a, b) {
                var aVal = a.text.toLowerCase();
                var bVal = b.text.toLowerCase();
                if (aVal < bVal) { return -1; }
                if (aVal > bVal) { return 1; }
                return 0;
            });
        } else {
            onSort.push(function(a, b) {
                var aVal = a.value.toLowerCase();
                var bVal = b.value.toLowerCase();
                if (aVal < bVal) { return -1; }
                if (aVal > bVal) { return 1; }
                return 0;
            });
        }

        //configure events
        if (settings[index].useFilters) {
            $('#' + group1[index].filter).keyup(function() {
                Filter(group1[index]);
            });
            $('#' + group2[index].filter).keyup(function() {
                Filter(group2[index]);
            });
            $('#' + group1[index].clear).click(function() {
                ClearFilter(group1[index]);
            });
            $('#' + group2[index].clear).click(function() {
                ClearFilter(group2[index]);
            });
        }
        if (IsMoveMode(settings[index])) {
            $('#' + group2[index].view).dblclick(function() {
                MoveSelected(group2[index], group1[index]);
            });
            $('#' + settings[index].to1).click(function() {
                MoveSelected(group2[index], group1[index]);
            });
            $('#' + settings[index].allTo1).click(function() {
                MoveAll(group2[index], group1[index]);
            });
        } else {
            $('#' + group2[index].view).dblclick(function() {
                RemoveSelected(group2[index], group1[index]);
            });
            $('#' + settings[index].to1).click(function() {
                RemoveSelected(group2[index], group1[index]);
            });
            $('#' + settings[index].allTo1).click(function() {
                RemoveAll(group2[index], group1[index]);
            });
        }
        $('#' + group1[index].view).dblclick(function() {
            MoveSelected(group1[index], group2[index]);
        });
        $('#' + settings[index].to2).click(function() {
            MoveSelected(group1[index], group2[index]);
        });
        $('#' + settings[index].allTo2).click(function() {
            MoveAll(group1[index], group2[index]);
        });

        //initialize the counters
        if (settings[index].useCounters) {
            UpdateLabel(group1[index]);
            UpdateLabel(group2[index]);
        }

        //pre-sort item sets
        if (settings[index].useSorting) {
            SortOptions(group1[index]);
            SortOptions(group2[index]);
        }

        //hide the storage boxes
        $('#' + group1[index].storage + ',#' + group2[index].storage).css('display', 'none');

        //attach onSubmit functionality if desired
        if (settings[index].selectOnSubmit) {
            $('#' + settings[index].box2View).closest('form').submit(function() {
                $('#' + settings[index].box2View).children('option').attr('selected', 'selected');
            });
        }
    };

    function UpdateLabel(group) {
        var showingCount = $("#" + group.view + " option").size();
        var hiddenCount = $("#" + group.storage + " option").size();
        $("#" + group.counter).text('Showing ' + showingCount + ' of ' + (showingCount + hiddenCount));
    }

    function Filter(group) {
        var index = group.index;
        var filterLower;
        if (settings[index].useFilters) {
            filterLower = $('#' + group.filter).val().toString().toLowerCase();
        } else {
            filterLower = '';
        }
        $('#' + group.view + ' option').filter(function(i) {
            var toMatch = $(this).text().toString().toLowerCase();
            return toMatch.indexOf(filterLower) == -1;
        }).appendTo('#' + group.storage);
        $('#' + group.storage + ' option').filter(function(i) {
            var toMatch = $(this).text().toString().toLowerCase();
            return toMatch.indexOf(filterLower) != -1;
        }).appendTo('#' + group.view);
        try {
            $('#' + group.view + ' option').removeAttr('selected');
        }
        catch (ex) {
            //swallow the error for IE6
        }
        if (settings[index].useSorting) { SortOptions(group); }
        if (settings[index].useCounters) { UpdateLabel(group); }
    }

    function SortOptions(group) {
        var $toSortOptions = $('#' + group.view + ' option');
        $toSortOptions.sort(onSort[group.index]);
        $('#' + group.view).empty().append($toSortOptions);
    }

    function MoveSelected(fromGroup, toGroup) {
        if (IsMoveMode(settings[fromGroup.index])) {
            $('#' + fromGroup.view + ' option:selected').appendTo('#' + toGroup.view);
        } else {
            $('#' + fromGroup.view + ' option:selected:not([class*=copiedOption])').clone().appendTo('#' + toGroup.view).end().end().addClass('copiedOption');
        }
        try {
            $('#' + fromGroup.view + ' option,#' + toGroup.view + ' option').removeAttr('selected');
        }
        catch (ex) {
            //swallow the error for IE6
        }
        Filter(toGroup);
        if (settings[fromGroup.index].useCounters) { UpdateLabel(fromGroup); }
    }

    function MoveAll(fromGroup, toGroup) {
        if (IsMoveMode(settings[fromGroup.index])) {
            $('#' + fromGroup.view + ' option').appendTo('#' + toGroup.view);
        } else {
            $('#' + fromGroup.view + ' option:not([class*=copiedOption])').clone().appendTo('#' + toGroup.view).end().end().addClass('copiedOption');
        }
        try {
            $('#' + fromGroup.view + ' option,#' + toGroup.view + ' option').removeAttr('selected');
        }
        catch (ex) {
            //swallow the error for IE6
        }
        Filter(toGroup);
        if (settings[fromGroup.index].useCounters) { UpdateLabel(fromGroup); }
    }

    function RemoveSelected(removeGroup, otherGroup) {
        $('#' + otherGroup.view + ' option.copiedOption').add('#' + otherGroup.storage + ' option.copiedOption').remove();
        try {
            $('#' + removeGroup.view + ' option:selected').appendTo('#' + otherGroup.view).removeAttr('selected');
        }
        catch (ex) {
            //swallow the error for IE6
        }
        $('#' + removeGroup.view + ' option').add('#' + removeGroup.storage + ' option').clone().addClass('copiedOption').appendTo('#' + otherGroup.view);
        Filter(otherGroup);
        if (settings[removeGroup.index].useCounters) { UpdateLabel(removeGroup); }
    }

    function RemoveAll(removeGroup, otherGroup) {
        $('#' + otherGroup.view + ' option.copiedOption').add('#' + otherGroup.storage + ' option.copiedOption').remove();
        try {
            $('#' + removeGroup.storage + ' option').clone().addClass('copiedOption').add('#' + removeGroup.view + ' option').appendTo('#' + otherGroup.view).removeAttr('selected');
        }
        catch (ex) {
            //swallow the error for IE6
        }
        Filter(otherGroup);
        if (settings[removeGroup.index].useCounters) { UpdateLabel(removeGroup); }
    }

    function ClearFilter(group) {
        $('#' + group.filter).val('');
        $('#' + group.storage + ' option').appendTo('#' + group.view);
        try {
            $('#' + group.view + ' option').removeAttr('selected');
        }
        catch (ex) {
            //swallow the error for IE6
        }
        if (settings[group.index].useSorting) { SortOptions(group); }
        if (settings[group.index].useCounters) { UpdateLabel(group); }
    }

    function IsMoveMode(currSettings) {
        return currSettings.transferMode == 'move';
    }
})(jQuery);