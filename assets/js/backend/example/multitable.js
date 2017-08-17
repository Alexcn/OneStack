define(['jquery', 'bootstrap', 'backend', 'table', 'form'], function ($, undefined, Backend, Table, Form) {

    var Controller = {
        index: function () {
            // 初始化表格参数配置
            Table.api.init();

            // 表格1
            var table1 = $("#table1").bootstrapTable({
                url: 'data/attachment.json',
                extend: {
                    index_url: 'data/attachment.json',
                    add_url: 'attachment-edit.html',
                    edit_url: 'attachment-edit.html',
                    del_url: 'data/del.json',
                    multi_url: 'data/multi.json',
                    table: 'attachment',
                },
                toolbar: '#toolbar1',
                sortName: 'id',
                search: false,
                columns: [
                    [
                        {field: 'state', checkbox: true, },
                        {field: 'id', title: 'ID'},
                        {field: 'url', title: __('Url'), formatter: Table.api.formatter.url},
                        {field: 'imagewidth', title: __('Imagewidth')},
                        {field: 'imageheight', title: __('Imageheight')},
                        {field: 'mimetype', title: __('Mimetype')},
                        {field: 'operate', title: __('Operate'), events: Table.api.events.operate, formatter: Table.api.formatter.operate}
                    ]
                ]
            });

            // 为表格1绑定事件
            Table.api.bindevent(table1);

            // 表格2
            var table2 = $("#table2").bootstrapTable({
                url: 'data/crontab.json',
                extend: {
                    index_url: 'data/crontab.json',
                    add_url: 'crontab-edit.html',
                    edit_url: 'crontab-edit.html',
                    del_url: 'data/del.json',
                    multi_url: 'data/multi.json',
                    table: 'crontab',
                },
                toolbar: '#toolbar2',
                sortName: 'weigh',
                search: false,
                columns: [
                    [
                        {field: 'state', checkbox: true, },
                        {field: 'id', title: 'ID'},
                        {field: 'type', title: __('Type')},
                        {field: 'title', title: __('Title')},
                        {field: 'maximums', title: __('Maximums')},
                        {field: 'executes', title: __('Executes')},
                        {field: 'begintime', title: __('Begin time'), formatter: Table.api.formatter.datetime},
                        {field: 'endtime', title: __('End time'), formatter: Table.api.formatter.datetime},
                        {field: 'executetime', title: __('Execute time'), formatter: Table.api.formatter.datetime},
                        {field: 'weigh', title: __('Weigh')},
                        {field: 'status', title: __('Status'), formatter: Table.api.formatter.status},
                        {field: 'operate', title: __('Operate'), events: Table.api.events.operate, formatter: Table.api.formatter.operate}
                    ]
                ]
            });

            // 为表格2绑定事件
            Table.api.bindevent(table2);
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
            },
        }
    };
    return Controller;
});