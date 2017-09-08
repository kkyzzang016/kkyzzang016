<%@ page language="java" contentType="text/html; charset=EUC-KR"
 pageEncoding="EUC-KR"%>
<%@ include file="../header.jsp" %>
<%@ include file="sub_img.html"%>
<%@ include file="sub_menu.jsp" %>
 <article>
 <h2> Cart List </h2>
 <form name="formm" method="post">
 <c:choose>
 <c:when test= "${cartList.size() == 0}">
 <h3 style="color: red;text-align: center;"> ��ٱ��ϰ� ������ϴ�. </h3>
 </c:when>
 <c:otherwise>
 <table id="cartList">
 <tr>
 <th>��ǰ��</th><th>����</th><th>����</th><th>�ֹ���</th><th>����</th>
 </tr>

 <c:forEach items="${cartList}" var="cartVO">
 <tr>
 <td>
 <a href=
"ShoppingMallServlet?command=product_detail&pseq=${cartVO.pseq}">
 <h3> ${cartVO.pname} </h3>
 </a>
 </td>
 <td> ${cartVO.quantity} </td>
 <td>
 <fmt:formatNumber value="${cartVO.price2*cartVO.quantity}"
 type="currency"/>
 </td> 
 <td><fmt:formatDate value="${cartVO.indate}" type="date"/></td>
 <td><input type="checkbox" name="cseq" value= "${cartVO.cseq}"> </td>
 </tr>
 </c:forEach>

 <tr>
 <th colspan="2"> �� �� </th>
 <th colspan="2">
 <fmt:formatNumber value="${totalPrice}" type="currency"/><br>
 </th>
 <th><a href="#" onclick="go_cart_delete()"><h3>�����ϱ�</h3></a></th>
 </tr>
 </table>
 </c:otherwise>
 </c:choose>

 <div class="clear"></div>

 <div id="buttons" style="float: right">
 <input type="button" value="���� ����ϱ�" class="cancel"
onclick="location.href='ShoppingMallServlet?command=main'">
 <c:if test= "${cartList.size() != 0}">
 <input type="button" value="�ֹ��ϱ�" class="submit"
onclick="go_order_insert()">
 </c:if>
 </div>
 </form>
 </article>
<%@ include file="../footer.jsp" %>