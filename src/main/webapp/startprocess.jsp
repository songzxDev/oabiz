<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.js" charset="UTF-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-migrate-1.4.1.js" charset="UTF-8"></script>
<script type="text/javascript">
	var $jq = jQuery.noConflict();
	$jq.fn.serializeObject = function() {
		var o = {};
		var a = this.serializeArray();
		$jq.each(a, function() {
			if (o[this.name]) {
				if (!o[this.name].push) {
					o[this.name] = [ o[this.name] ];
				}
				o[this.name].push(this.value || '');
			} else {
				o[this.name] = this.value || '';
			}
		});
		return o;
	};
	$jq(document).ready(function() {
		$jq("#workFlow_form_submit_button").on("click", function() {
			var formdata = $jq("#workFlow_form").serializeObject();
			console.info(formdata);
			alert(formdata);
			$jq.ajax({
				url : "${pageContext.request.contextPath}/workFlow/startProcess",
				type : "post",
				data : JSON.stringify(formdata),
				contentType : "application/json;charset=UTF-8",
				dataType : "json",
				success : function(receiptMap) {
					console.log(receiptMap);
					alert("流程启动成功！");
				}
			});
		});
	});
</script>
<body>
	<div>
		<form id="workFlow_form" method="post">
			<table id="workFlow_form_table">
				<thead></thead>
				<tbody>
					<tr>
						<th>流程KEY值</th>
						<td><input type="text" name="processDefinitionKey" id="processDefinitionKey" /></td>
					</tr>
					<tr>
						<th>业务单据主键</th>
						<td><input type="text" name="businessKey" id="businessKey" /></td>
					</tr>
					<tr>
						<th>流程启动人</th>
						<td><input type="text" name="authenticatedUserId" id="authenticatedUserId" /></td>
					</tr>
					<tr>
						<th></th>
						<td><input type="button" name="workFlow_form_submit_button" value="提交" id="workFlow_form_submit_button" /></td>
					</tr>
				</tbody>
				<tfoot></tfoot>
			</table>
		</form>
	</div>
</body>
</html>