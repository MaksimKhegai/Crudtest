<%@ include file="/html/crudtest/init.jsp"%>
<%@ include file="/html/crudtest/popup.jsp"%>

<portlet:renderURL var="addAuthorFormURL">
	<portlet:param name="mvcPath" value="/html/crudtest/add_author.jsp"></portlet:param>
</portlet:renderURL>

<portlet:actionURL name="editAuthor" var="editAuthorURL"></portlet:actionURL>
<portlet:actionURL name="removeAuthor" var="removeAuthorURL"></portlet:actionURL>

<table id="DataTable" class="display">
	<thead>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Birth Date</th>
			<th></th>
			<th></th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="author" begin="0" items="${authorsArray}"
			varStatus="status">
			<c:if test="${author.viewPermission}">
			<tr>
				<td>${author.authorId}</td>
				<td>${author.name}</td>
				<td>${author.birthDate}</td>

				<td><c:if test='${author.editPermission}'>
						<liferay-security:permissionsURL
							modelResource="<%= Author.class.getName() %>"
							modelResourceDescription="Authors permissions"
							resourcePrimKey="${author.authorId}" var="entryURL" />
						<liferay-ui:icon image="permissions" url="<%= entryURL %>" />
					</c:if></td>

				<td><c:if test='${author.editPermission}'>
						<aui:form action="<%=editAuthorURL%>"
							name="<portlet:namespace/>fm">
							<aui:fieldset>
								<aui:input name="AuthorIndex" value="${status.index}"
									type="hidden">
								</aui:input>
							</aui:fieldset>
							<aui:button type="submit" value="Edit"></aui:button>
						</aui:form>
					</c:if></td>


				<td><c:if test='${author.deletePermission}'>
						<aui:form action="<%=removeAuthorURL%>"
							name="deleteForm${status.index}">
							<aui:fieldset>
								<aui:input name="AuthorIndex" value="${status.index}"
									type="hidden">
								</aui:input>
							</aui:fieldset>
							<aui:button style="color:red"
								onClick="javascript:showConfirmation(${status.index})"
								value="Delete"></aui:button>
						</aui:form>
					</c:if></td>

			</tr>
			</c:if>
		</c:forEach>
	</tbody>
</table>

<c:if test='${permissionsObject.globalPermissions.add}'>
	<aui:button-row cssClass="crudtest-buttons">
		<aui:button onClick="<%= addAuthorFormURL.toString() %>"
			value="Add an author"></aui:button>
	</aui:button-row>
</c:if>