<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${user_name } 고객님의 계좌 상세정보</h1>
	<table border="1">
		<tr>
			<th>은행명</th>
			<th>계좌번호</th>
			<th>상품명</th>
			<th>계좌잔액</th>
			<th>출금가능금액</th>
		</tr>
		<tr>
			<td>${account.bank_name }</td>
			<td>${account_num_masked }</td>
			<td>${account.product_name }</td>
			<td>${account.balance_amt }</td>
			<td>${account.available_amt }</td>
		</tr>
	</table>
	<hr>
	<%-- 임시) 송금 대상 정보 입력 --%>
	<h1>송금 대상 정보 입력(임시)</h1>
	<form action="bank_withdraw" method="post">
		<%-- 핀테크 이용번호(fintech_use_num) 전달 --%>
		<input type="hidden" name="fintech_use_num" value="${account.fintech_use_num }">
		<table border="1">
			<tr>
				<th>예금주명</th>
				<th>은행코드</th>
				<th>계좌번호</th>
				<th>핀테크이용번호</th>
				<th>송금할 금액</th>
				<th></th>
			</tr>
			<tr>
				<td><input type="text" name="recv_client_name"></td>
				<td><input type="text" name="recv_client_bank_code"></td>
				<td><input type="text" name="recv_client_account_num"></td>
				<td><input type="text" name="recv_client_fintech_use_num"></td>
				<td><input type="text" name="tran_amt"></td>
				<td><input type="submit" value="송금(출금이체)"></td>
			</tr>
		</table>
	</form>
</body>
</html>











