<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>远程医疗服务管理员系统</title>
    <link rel="icon" href="assets/images/favicon.ico"/>
    <link rel="stylesheet" href="assets/libs/layui/css/layui.css">
    <link rel="stylesheet" href="assets/common.css">
</head>

<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">远程医疗服务管理员系统</div>
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item" lay-unselect>
                <a href="" target="_blank" id="ag">
                    <i class="layui-icon layui-icon-website"></i>
                </a>
            </li>
        </ul>
        
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item" lay-unselect>
                <a id="btnUP"><img src="assets/images/head.png" class="layui-nav-img"><span id="uName">用户名</span></a>
            </li>
            <li class="layui-nav-item" lay-unselect>
                <a id="btnExit"><i class="layui-icon layui-icon-return"></i> 退出登录</a>
            </li>
        </ul>
	</div>

    <div class="layui-side">
        <div class="layui-side-scroll">
            <ul class="layui-nav layui-nav-tree" style="margin-top: 10px;">
            
                <li class="layui-nav-item layui-nav-itemed">
                    <a><i class="layui-icon layui-icon-set"></i>&emsp;设置</a>
                    <dl class="layui-nav-child">
                        <dd><a lay-href=login.html>Signin</a></dd>
                        <dd><a lay-href="registration.html">Signup</a></dd>
                        <dd><a lay-href="AdminInvite?userid=<s:property value="user.userid"/>">Invite Manage</a></dd>
                        <dd><a lay-href="UserManage?userid=<s:property value="user.userid"/>">User Manage</a></dd>
                    </dl>
                </li>
                
                <li class="layui-nav-item">
                    <a><i class="layui-icon layui-icon-console"></i>&emsp;基础信息管理</a>
                    <dl class="layui-nav-child"></dd>
                        <dd><a lay-href="PaVectSelect?userid=<s:property value="user.userid"/>">患者管理</a></dd>
						<dd><a lay-href="DoctorVectSelect?userid=<s:property value="user.userid"/>">医生管理</a></dd>
						<dd><a lay-href="NurseVectSelect?userid=<s:property value="user.userid"/>">护士管理</a></dd>
                    </dl>
                </li>
                
                <li class="layui-nav-item">
                    <a><i class="layui-icon layui-icon-list"></i>&emsp;健康数据及病历管理</a>
                    <dl class="layui-nav-child">
                        <dd><a lay-href="ExamVectSelect?userid=<s:property value="user.userid"/>">体检信息管理</a></dd>
                        <dd><a lay-href="CaseVectSelect?userid=<s:property value="user.userid"/>">电子病历管理</a></dd>
                    </dl>
				</li>
            
             	<li class="layui-nav-item">
                    <a><i class="layui-icon layui-icon-list"></i>&emsp;诊前问答信息管理</a>
                    <dl class="layui-nav-child">
                    	<dd><a lay-href="QuestionVectSelect?userid=<s:property value="user.userid"/>">诊前问题管理</a></dd>
                        <dd><a lay-href="AnswerVectSelect?userid=<s:property value="user.userid"/>">患者答题管理</a></dd>
                    </dl>
                </li>
                
            	<li class="layui-nav-item">
                    <a><i class="layui-icon layui-icon-console"></i>&emsp;统计分析</a>
                    <dl class="layui-nav-child">
                    	<dd><a lay-href="graph?userid=<s:property value="user.userid"/>">统计分析病种统计</a></dd>
                    	<!-- <dd><a lay-href="graphs.html">统计分析曲线图</a></dd>  -->
                    	<dd><a lay-href="graphsdatequxian.jsp">使用时间段曲线图</a></dd>
                    	<dd><a lay-href="graphsaddress.jsp">统计分析地域统计</a></dd>
                    	<dd><a lay-href="graphsdate.jsp">统计分析日期统计</a></dd>
                    	<dd><a lay-href="graphssex.jsp">统计分析性别统计</a></dd>
                    </dl>
            	</li>
            	
			</ul>
        </div>
    </div>

    <div class="layui-body">
        <iframe name="body" class="admin-iframe" src="HomeAdmin.jsp" frameborder="0"></iframe>
    </div>
</div>
<!-- 修改密码弹窗 -->
<script type="text/html" id="upModel">
    <form class="layui-form model-form" id="formPsw">
        <div class="layui-form-item">
            <label class="layui-form-label">原始密码:</label>
            <div class="layui-input-block">
                <input type="password" name="oldPsw" placeholder="请输入原始密码" class="layui-input"
                       lay-verType="tips" lay-verify="required" required/>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">新密码:</label>
            <div class="layui-input-block">
                <input type="password" name="newPsw" placeholder="请输入新密码" class="layui-input"
                       lay-verType="tips" lay-verify="required|psw" required/>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">确认密码:</label>
            <div class="layui-input-block">
                <input type="password" name="rePsw" placeholder="请再次输入新密码" class="layui-input"
                       lay-verType="tips" lay-verify="required|repsw" required/>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block text-right">
                <button class="layui-btn layui-btn-primary" type="button" ew-event="closeDialog">取消</button>
                <button class="layui-btn" lay-filter="submitPsw" lay-submit>保存</button>
            </div>
        </div>
    </form>
</script>

<script type="text/javascript" src="assets/libs/layui/layui.js"></script>
<script type="text/javascript" src="assets/common.js"></script>
<script>
    layui.use(['jquery', 'layer', 'element', 'form', 'admin'], function () {
        var $ = layui.jquery;
        var layer = layui.layer;
        var element = layui.element;
        var form = layui.form;
        var admin = layui.admin;
/*
        if (!admin.getToken()) {
            location.replace('login.html');
        }
*/


        // 退出登录
        $('#btnExit').click(function () {
            layer.confirm('确定退出登录吗？', function (i) {
                layer.close(i);
                admin.removeToken();
                location.replace('login.html');
            });
        });

        // 修改密码
        $('#btnUP').click(function () {
            layer.open({
                type: 1,
                title: '修改密码',
                area: '360px',
                offset: '65px',
                content: $('#upModel').html()
            });
        });

        // 监听修改密码表单提交
        form.on('submit(submitPsw)', function (d) {
            layer.load(2);
            admin.req('user/psw', d.field, function (res) {
                if (res.code == 200) {
                    layer.closeAll('loading');
                    layer.closeAll('page');
                    layer.msg(res.msg, {icon: 1, time: 1500}, function () {
                        // location.replace('login.html');
                    });
                } else {
                    layer.closeAll('loading');
                    layer.msg(res.msg, {icon: 2});
                }
            }, 'PUT');
            return false;
        });

        // 添加表单验证方法
        form.verify({
            psw: [/^[\S]{5,12}$/, '密码必须5到12位，且不能出现空格'],
            repsw: function (t) {
                if (t !== $('#formPsw input[name=newPsw]').val()) {
                    return '两次密码输入不一致';
                }
            }
        });

        //
        $('#ag').mouseenter(function () {
            layer.tips("远程医疗管理员系统 ", this, {
                tips: [2, '#3A3D49'], time: -1, success: function (layero, index) {
                    $(layero).css({'top': '10px'});
                }
            });
        });
        $('#ag').mouseleave(function () {
            layer.closeAll('tips');
        });
    });
</script>
</body>
</html>