<%@ include file="/html/crudtest/init.jsp" %>
<%@ include file="/html/crudtest/popup.jsp" %>

<%@ page import="com.liferay.test.portlet.service.permission.BookPermission" %>
<%@ page import="com.liferay.test.portlet.PermissionsHolder" %>

<portlet:renderURL var="addBookFormURL">
	<portlet:param name="mvcPath" value="/html/crudtest/add_book.jsp"></portlet:param>
</portlet:renderURL>

<portlet:actionURL name="removeBook" var="removeBookURL"></portlet:actionURL>
<portlet:actionURL name="editBook" var="editBookURL"></portlet:actionURL>

<table id="DataTable" class="display">
    <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
			<th>Release Date</th>
            <th>Genre</th>
            <th>Author</th>
            <th>Publisher</th>
            <th></th>
			<th></th>
        </tr>
    </thead>
    <tbody>
			<c:forEach var="book" begin="0" items="${booksArray}" varStatus="status">
				<tr>
					<td>${book.bookId}</td>
		            <td>${book.name}</td>
		            <td>${book.releaseDate}</td>
		            <td>${genresArray[book.genreId].name}</td>
		            <td>${authorsArray[book.authorId].name}</td>
		            <td>${publishersArray[book.publisherId].name}</td>
		            
	 		        	<td>
	 		        		<c:if test='${permissionsObject.bookPermissions[status.index].update}'>
								<aui:form action="<%=editBookURL%>" name="<portlet:namespace/>fm">
									<aui:fieldset>
										<aui:input name="BookIndex" value="${status.index}" type="hidden">
										</aui:input>
									</aui:fieldset>
									<aui:button type="submit" value="Edit"></aui:button>
								</aui:form>
							</c:if>
						</td>
					
					
						<td>
							<c:if test='${permissionsObject.bookPermissions[status.index].delete}'>
								<aui:form action="<%=removeBookURL%>" name="deleteForm${status.index}">
									<aui:fieldset>
										<aui:input name="BookIndex" value="${status.index}" type="hidden">
										</aui:input>
									</aui:fieldset>
									<aui:button style="color:red" onClick="javascript:showConfirmation(${status.index})" value="Delete"></aui:button>
								</aui:form>	
							</c:if>
						</td>

				</tr>
			</c:forEach>
    </tbody>
</table>

<c:if test='${permissionsObject.globalPermissions.add}'>
	<aui:button-row cssClass="crudtest-buttons">
		<aui:button onClick="<%= addBookFormURL.toString() %>" value="Add a book"></aui:button>
	</aui:button-row>
</c:if>