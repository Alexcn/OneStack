define(['jquery', 'bootstrap', 'backend', 'table', 'form'], function ($, undefined, Backend, Table, Form) {

    var Controller = {
        index: function () {
            // 初始化表格参数配置
            Table.api.init({
                extend: {
                    index_url: 'data/test.json',
                    add_url: 'test-edit.html',
                    edit_url: 'test-edit.html',
                    del_url: 'data/del.json',
                    multi_url: 'data/multi.json',
                    table: 'test',
                }
            });

            var table = $("#table");

            // 初始化表格
            table.bootstrapTable({
                url: $.fn.bootstrapTable.defaults.extend.index_url,
                pk: 'id',
                sortName: 'weigh',
                columns: [
                    [
                        {checkbox: true},
                        {field: 'id', title: __('Id')},
                        {field: 'category_id', title: __('Category_id')},
                        {field: 'category_ids', title: __('Category_ids')},
                        {field: 'user_id', title: __('User_id')},
                        {field: 'user_ids', title: __('User_ids')},
                        {field: 'week_text', title: __('Week'), operate: false},
                        {field: 'flag', title: __('Flag'), formatter: Table.api.formatter.flag},
                        {field: 'genderdata_text', title: __('Gender'), operate: false},
                        {field: 'hobbydata_text', title: __('Hobby'), operate: false, formatter: Table.api.formatter.label},
                        {field: 'title', title: __('Title'), width: "150px"},
                        {field: 'image', title: __('Image'), formatter: Table.api.formatter.image},
                        {field: 'images', title: __('Images'), formatter: Table.api.formatter.images},
                        {field: 'attachfile', title: __('Attachfile')},
                        {field: 'keywords', title: __('Keywords')},
                        {field: 'description', title: __('Description')},
                        {field: 'price', title: __('Price')},
                        {field: 'views', title: __('Views')},
                        {field: 'startdate', title: __('Startdate')},
                        {field: 'activitytime', title: __('Enddate')},
                        {field: 'year', title: __('Year')},
                        {field: 'times', title: __('Times')},
                        {field: 'refreshtime', title: __('Refreshtime'), formatter: Table.api.formatter.datetime},
                        {field: 'createtime', title: __('Createtime'), formatter: Table.api.formatter.datetime},
                        {field: 'updatetime', title: __('Updatetime'), formatter: Table.api.formatter.datetime},
                        {field: 'weigh', title: __('Weigh')},
                        {field: 'switch', title: __('Switch')},
                        {field: 'status', title: __('Status'), formatter: Table.api.formatter.status},
                        {field: 'state_text', title: __('State'), operate: false},
                        {field: 'operate', title: __('Operate'), events: Table.api.events.operate, formatter: Table.api.formatter.operate}
                    ]
                ]
            });

            // 为表格绑定事件
            Table.api.bindevent(table);
        },
        add: function () {
            Controller.api.bindevent();
        },
        edit: function () {
            Controller.api.bindevent();
        },
        api: {
            bindevent: function () {
                Form.api.bindevent($("form[role=form]"));
            }
        }
    };
    return Controller;
});