document.write(`

<div class="page" id="app">
    <div class="nav-left" v-show="navLeftFlag" ref="navLeft">
        <div class="LogoName">
            <img src="css/Images/username.png" style="width: 25px; height: 25px;">
            后台数据管理系统
        </div>

        <div class="navDiv">
            <div class="navName">导航</div>
            <div class="nav-list" style="position:relative; width:258px; left: -18px;">
                <ul>
                    <li class="nav-tab a_active waves-effect">
                        <a href="../home.html" class="li-a active" target="iframe"><i class='bx bx-home-smile'></i> 主页
                            <span class="badge badge-pill badge-primary" style="float: right; 
                            background-color: #0c63e4; position: relative; top: 2px; right: 4px;">3</span>
                        </a>
                    </li>
                    <!-- <li class="nav-tab">
                        <a href="#" class="li-a"><i class='bx bx-home-smile'></i> 设备管理</a>
                    </li> -->
                    <li class="nav-tab nav-ul">
                        <a href="javascript:void[0]" class="li-a"><i class='bx bx-search'></i> 数据查询
                            <i class='bx bx-chevron-right' style="float: right;"></i></a>
                        <div class="nav-box">
                            <a href="html/device/search-auto.html" class="li-a-a" target="iframe">自动查询</a>
                        </div>
                        <div class="nav-box">
                            <a href="html/device/search-manual.html" class="li-a-a" target="iframe">手动查询</a>
                        </div>
                    </li>
                    <li class="nav-tab nav-ul">
                        <a href="javascript:void[0]" class="li-a"><i class='bx bx-edit'></i> 数据管理
                            <i class='bx bx-chevron-right' style="float: right;"></i></a>
                        <div class="nav-box">
                            <a href="html/device/administration.html" class="li-a-a" target="iframe">手动更改</a>
                        </div>
                    </li>
                    <li class="nav-tab nav-ul">
                        <a href="javascript:void[0]" class="li-a" target="iframe"><i class='bx bx-layer'></i> 权限管理
                            <i class='bx bx-chevron-right' style="float: right;"></i></a>
                        <div class="nav-box">
                            <a href="html/device/user.html" class="li-a-a" target="iframe">用户信息</a>
                        </div>
                    </li>
                    <li class="nav-tab nav-ul">
                        <a href="javascript:void[0]" class="li-a"><i class='bx bx-cog'></i> 界面设置
                            <i class='bx bx-chevron-right' style="float: right;"></i></a>
                        <div class="nav-box">
                            <a href="html/device/theme.html" class="li-a-a" target="iframe">主题样式</a>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>

    <div class="nav-right" ref="navRight">
        <div class="nav-top">
            <button type="button" class="btn btn-primary btn-sm hiddenBtn" style="line-height: 10px;" @click="isShowLeft">
                <i class="bx bx-grid-alt" style="font-size: 16px;"></i>
            </button>
            
            <button type="button" class="btn btn-primary btn-sm hiddenBtn" style="line-height: 10px;" @click="isShowLeft">
                <i class="bx bx-grid-alt" style="font-size: 16px;"></i>
            </button>
            <!-- <button type="button" class="btn btn-primary btn-sm showBtn" style="line-height: 10px; display: none;" onclick="showNavRight">
                <i class="bx bx-expand" style="font-size: 16px;"></i>
            </button> -->
        </div>
        
        <div class="content-page" ref="cPage">
            <iframe name="iframe" width="100%" height="100%" frameborder="0" src="../home.html"></iframe>
        </div>
        
        
    </div>

</div>

<div style="width: 150px; position: relative; left: 1140px; bottom: 42px; z-index: 200;font-size: 14px;">
    <div class="dropdown">
        <span class="dropdown-toggle" data-bs-toggle="dropdown" style="margin: 5px; cursor: pointer;
        border: 1px solid #dedede; padding: 5px 12px; border-radius: 15px;">个人信息</span>
        <ul class="dropdown-menu" style="line-height: 20px; width: 94px; text-align: center;font-size: 12px;">
            <li><a class="dropdown-item" href="html/device/theme.html" class="li-a-a" target="iframe">个人信息</a></li>
            <li><a class="dropdown-item" href="html/device/theme.html" class="li-a-a" target="iframe">修改密码</a></li>
            <li><a class="dropdown-item" @click="logout" onclick="logout()" class="li-a-a" target="iframe">退出登录</a></li>
        </ul>
    </div>
</div>

<script src="js/vue.min.js"></script>
<script src="https://www.jq22.com/jquery/jquery-1.10.2.js"></script>
<script type="text/javascript">
    $(function() {
        let navflag = false;
        $('.nav-tab').click(function() {
            $(this).siblings().each(function() {
                $(this).removeClass('a_active');
                // $(this).removeClass('a_active');
                $(this).find('.nav-box').css('height', '0')
                //关闭右侧箭头
                if ($(this).attr('class').indexOf('nav-ul') != -1) {
                    $(this).find('.bx-chevron-right').css('transform', 'rotateZ(0deg)')
                    $(this).find('.bx-chevron-right').css('transition', 'all .5s')
                    $(this).removeClass('nav-show')
                    // $(this).find('div').removeClass('nav-box')
                }
            })
            //当前选中
            $(this).addClass('a_active')
            $(this).find('.li-a').addClass('active')
            // 打开右侧箭头
            $(this).find('.bx-chevron-right').css('transform', 'rotateZ(90deg)')
            $(this).find('.bx-chevron-right').css('transition', 'all .5s')
            $(this).addClass('nav-show')
            // $(this).find('div').addClass('nav-box')
        })
        /* 二级菜单a点击事件 */
        $(".li-a-a").click(function() {
            $(".li-a-a").each(function() {
                $(this).removeClass('active-li-a');
            })
            $(this).addClass('active-li-a');
        })

    })
    const vue = new Vue({
        el: '#app',
        data: {
            navLeftFlag: true
        },
        methods: {
            isShowLeft() {
                if (this.navLeftFlag ) {
                    this.$refs.navRight.style.paddingLeft = '0px'
                    this.$refs.cPage.style.left = '0px';
                    this.navLeftFlag = false;
                    // this.$refs.navLeft.style.width = '0px';
                    // setTimeout(()=>{
                    // \tthis.navLeftFlag = false;
                    // },200)
                } else {
                    this.$refs.navRight.style.paddingLeft = '240px';
                    this.$refs.cPage.style.left = '240px';
                    this.navLeftFlag = true;
                    // this.$refs.navLeft.style.width = '240px';
                    // setTimeout(()=>{
                    // \tthis.navLeftFlag = true;
                    // },200)
                }
            }
        }
    })
</script>

<script>
    function logout() {
        fetch("user/logout")
            .then(res => res.text())
            .then(res => {  //res就是后台返回的结果
                if (res === 'SUCCESS') {  //判断请求是否成功
                    $.message({message: "登出成功！", type: 'success'})
                    setTimeout(() => {
                        location.href = '/login.html'
                    }, 1000)
                } else {
                    alert("登出失败，请重试！")
                }
            })
    }
</script>
`)