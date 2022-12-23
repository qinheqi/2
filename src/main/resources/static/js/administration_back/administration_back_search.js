document.write(`

    <div class="layui-card" style="border: 1px solid #E8E8E8">
        <div class="layui-card-body" style="height: 50px;">
            <form action="" method="post" id="queryForm" name="queryForm"
                  class="layui-form layui-form-pane1">
                <div class="layui-form-item" style="margin: 5px;">
                    <div class="layui-form-item" style="margin: 5px;">
                        <div class="layui-row">
                            <div class="layui-col-md1">
                                <label class="layui-form-label"
                                       style="width: 57%; right:35%; margin: auto;">类别</label>
                            </div>
                            <div class="layui-col-md8">
                                <div class="layui-row">
                                    <div class="layui-col-md4">
                                        <div class="layui-input-inline" style="width: 98%; right:16%">
                                            <select name="type" lay-filter="form_type">
                                                <option value="" selected="selected">类型</option>
                                                <option value="新增">新增</option>
                                                <option value="删除">删除</option>
                                                <option value="修改">修改</option>
                                                <option value="查询">查询</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="layui-col-md4">
                                        <div class="layui-input-inline" style="width: 98%; right:10%">
                                            <select name="distract" lay-filter="form_distract">
                                                <option value="" selected="selected">地区</option>
                                                <option value="渝中区">渝中区</option>
                                                <option value="万州区">万州区</option>
                                                <option value="涪陵区">涪陵区</option>
                                                <option value="大渡口区">大渡口区</option>
                                                <option value="江北区">江北区</option>
                                                <option value="沙坪坝区">沙坪坝区</option>
                                                <option value="九龙坡区">九龙坡区</option>
                                                <option value="南岸区">南岸区</option>
                                                <option value="北碚区">北碚区</option>
                                                <option value="綦江区">綦江区</option>
                                                <option value="大足区">大足区</option>
                                                <option value="渝北区">渝北区</option>
                                                <option value="巴南区">巴南区</option>
                                                <option value="黔江区">黔江区</option>
                                                <option value="长寿区">长寿区</option>
                                                <option value="江津区">江津区</option>
                                                <option value="合川区">合川区</option>
                                                <option value="永川区">永川区</option>
                                                <option value="南川区">南川区</option>
                                                <option value="璧山区">璧山区</option>
                                                <option value="永川区">永川区</option>
                                                <option value="铜梁区">铜梁区</option>
                                                <option value="潼南区">潼南区</option>
                                                <option value="荣昌区">荣昌区</option>
                                                <option value="开州区">开州区</option>
                                                <option value="梁平区">梁平区</option>
                                                <option value="武隆区">武隆区</option>
                                                <option value="城口县">城口县</option>
                                                <option value="丰都县">丰都县</option>
                                                <option value="垫江县">垫江县</option>
                                                <option value="忠县">忠县</option>
                                                <option value="云阳县">云阳县</option>
                                                <option value="奉节县">奉节县</option>
                                                <option value="巫山县">巫山县</option>
                                                <option value="巫溪县">巫溪县</option>
                                                <option value="石柱土家族自治县">石柱土家族自治县</option>
                                                <option value="秀山土家族苗族自治县">秀山土家族苗族自治县</option>
                                                <option value="酉阳土家族苗族自治县">酉阳土家族苗族自治县</option>
                                                <option value="彭水苗族土家族自治县">彭水苗族土家族自治县</option>
                                                <option value="非地区语句">非地区语句</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="layui-col-md4">
                                        <div class="layui-input-inline" style="width: 98%; right: 4%">
                                            <select id="alias" name="alias" lay-verify="required" lay-search=""
                                                    lay-filter="form_alias">
                                                <option value="">选择或搜索别名</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="layui-col-md3">
                                <button @click="select" onclick="select()" type="button" class="layui-btn layui-btn-normal"
                                        style="width: 46%; height: 38px; padding: 0; font-size: 14px;
                                        position: relative; left: 2%">查询
                                </button>
                                <button @click="reset" onclick="reset()" type="reset" class="layui-btn layui-btn-normal"
                                        style="width: 46%; height: 38px; padding: 0; font-size: 14px; position: relative;
                                    left: 4%">重置
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>

`)