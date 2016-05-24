<%@ include file="/html/crudtest/init.jsp" %>
<%@ include file="/html/crudtest/popup.jsp" %>

<portlet:renderURL var="addGenreFormURL">
	<portlet:param name="mvcPath" value="/html/crudtest/add_genre.jsp"></portlet:param>
</portlet:renderURL>

<portlet:actionURL name="removeGenre" var="removeGenreURL"></portlet:actionURL>
<portlet:actionURL name="editGenre" var="editGenreURL"></portlet:actionURL>

<table id="DataTable" class="display">
    <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
			<th></th>
			<th></th>
        </tr>
    </thead>
    <tbody>
			<c:forEach var="genre" begin="0" items="${genresArray}" varStatus="status">
				<tr>
					<td>${genre.genreId}</td>
		            <td>${genre.name}</td>
 		            <td>	            	
 		            	<c:if test='${permissionsObject.genrePermissions[status.index].update}'>
							<aui:form action="<%=editGenreURL%>" name="<portlet:namespace/>fm">
								<aui:fieldset>
									<aui:input name="GenreIndex" value="${status.index}" type="hidden">
									</aui:input>
								</aui:fieldset>
								<aui:button type="submit" value="Edit"></aui:button>
							</aui:form>
						</c:if>
					</td>
					<td>
						<c:if test='${permissionsObject.genrePermissions[status.index].delete}'>
							<aui:form action="<%=removeGenreURL%>" name="deleteForm${status.index}">
								<aui:fieldset>
									<aui:input name="GenreIndex" value="${status.index}" type="hidden">
									</aui:input>
								</aui:fieldset>
								<aui:button style="color:red" onClick="javascript:showConfirmation(${status.index})" value="Delete">
								</aui:button>
							</aui:form>
						</c:if>
					</td>
				</tr>
			</c:forEach>
    </tbody>
</table>

<c:if test='${permissionsObject.globalPermissions.add}'>
	<aui:button-row cssClass="crudtest-buttons">
		<aui:button onClick="<%= addGenreFormURL.toString() %>" value="Add a genre"></aui:button>
	</aui:button-row>
</c:if>