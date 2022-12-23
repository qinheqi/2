document.write(`

    <div class="layui-card table-blue" style="border: 1px solid #E8E8E8">
        <div class="layui-card-body">
            <div class="layui-form-item" style="font-size: 18px; color: #333333;">
                <fieldset class="layui-elem-field layui-field-title"
                          style="margin-top: 10px; margin-bottom: 0;">
                    <legend><b>查询结果</b></legend>
                </fieldset>
            </div>

            <table class="layui-hide" id="table_Arbitrary" lay-filter="table_Arbitrary"></table>
            <script src="../../layui/layui.js"></script>
            <script>
                let layer, $, table;
                layui.use(['jquery', 'layer', 'table'], function () {
                    layer = layui.layer
                        , $ = layui.jquery
                        , table = layui.table;

                    table.render({
                        elem: '#table_Arbitrary'
                        , id: 'table_Arbitrary'
                        , toolbar: '#toolbarDemo'
                        , cols: [[
                            {checkbox: true, fixed: true}
                            , {field: 'null', title: '待查询'}
                        ]]
                        , data: [{"null": "待查询"}]
                        , page: true
                        , height: 315
                    });
                    //头工具栏事件
                    table.on('toolbar(table_Arbitrary)', function (obj) {
                        var checkStatus = table.checkStatus(obj.config.id); //获取选中行状态
                        switch (obj.event) {
                            case 'getCheckData':
                                var data = checkStatus.data;  //获取选中行数据
                                layer.alert(JSON.stringify(data));
                                break;
                        }
                        ;
                    });
                });
            </script>
        </div>
    </div>


`)