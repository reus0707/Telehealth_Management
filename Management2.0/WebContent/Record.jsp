<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${rootPath }/css/bootstrap.css" />
</head>
<body>
	<div style="display: flex; margin-top: 10px;">
		<a href="${rootPath }/record.jsp" target="myFrame" class="btn btn-danger"
			style="height: 35px; margin: 10px;">返回</a>
		<div style="width: 100%;">
			<div style="width: 100%; border: 1px solid gray; padding: 20px;">
				<div style="display: flex; width: 100%;">
					<div style="width: 50%;">
						<div
							style="display: flex; flex-direction: column; width: 30%; border: 1px solid gray;">
							<span
								style="width: 100%; display: flex; justify-content: center;">患者基本信息</span>
							<span style="width: 100%; padding-left: 10px;">ID: <span
								style="color: orange;">${currYuYue.id }</span></span> <span
								style="width: 100%; padding-left: 10px;">姓名: <span
								style="color: orange;">${currYuYue.name }</span></span> <span
								style="width: 100%; padding-left: 10px;">性别: <span
								style="color: orange;">${currYuYue.sex }</span></span> <span
								style="width: 100%; padding-left: 10px;">年龄: <span
								style="color: orange;">${currYuYue.age }</span></span>
						</div>
					</div>
					<div style="width: 50%;">
						<div
							style="display: flex; flex-direction: column; width: 30%; border: 1px solid gray;">
							<span
								style="width: 100%; display: flex; justify-content: center;">医生基本信息</span>
							<span style="width: 100%; padding-left: 10px;">ID: <span
								style="color: orange;">${currYuYue.doc_id }</span></span> <span
								style="width: 100%; padding-left: 10px;">姓名: <span
								style="color: orange;">${currYuYue.doc_name }</span></span> <span
								style="width: 100%; padding-left: 10px;">性别: <span
								style="color: orange;">${currYuYue.doc_sex }</span></span> <span
								style="width: 100%; padding-left: 10px;">年龄: <span
								style="color: orange;">${currYuYue.doc_age }</span></span>
						</div>
					</div>
				</div>
				<div
					style="display: flex; justify-content: center; border: 1px solid gray; padding: 20px; margin-top: 20px;">
					本次出诊时间：<span style="color: orange;">2019-3-3 08:30</span>
				</div>
			</div>
			<div
				style="padding-left: 20px; height: 180px; border: 1px solid gray; margin-top: 5px;">
				${currYuYue.info }</div>
			<div
				style="padding-left: 20px; height: 180px; border: 1px solid gray; margin-top: 5px;">
				${currYuYue.chuFang }</div>
		</div>
	</div>
</body>
</html>