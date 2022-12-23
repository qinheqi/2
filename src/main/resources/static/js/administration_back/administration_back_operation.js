document.write(`

    <div class="layui-card" style="border: 1px solid #E8E8E8">
        <div class="layui-card-body" style="height: 110px;">
            <div class="layui-row">
                <div class="layui-col-md11">
                    <div class="layui-input-block" style="width: 100%; margin: 5px auto;">
                        <textarea name="sql" v-model="sql"
                                  placeholder="请输入SQL语句" class="layui-textarea" style="resize:none;"></textarea>
                    </div>
                </div>
                <div class="layui-col-md1">
                    <button type="button" class="layui-btn layui-btn-normal" id="submitCommon" onclick="submitCommon()"
                            style="width: 80%; height: 100px; padding: 0; line-height: 30px; margin: 5px 0 0 7px;
                             position: relative; left: 8%; background-color: #F7BA2A;">操作
                    </button>
                </div>
            </div>
        </div>
    </div>

`)