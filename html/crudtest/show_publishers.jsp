<%@ include file="/html/crudtest/init.jsp" %>
<%@ include file="/html/crudtest/popup.jsp" %>

<portlet:renderURL var="addPublisherFormURL">
	<portlet:param name="mvcPath" value="/html/crudtest/add_publisher.jsp"></portlet:param>
</portlet:renderURL>

<portlet:actionURL name="removePublisher" var="removePublisherURL"></portlet:actionURL>
<portlet:actionURL name="editPublisher" var="editPublisherURL"></portlet:actionURL>

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
			<c:forEach var="publisher" begin="0" items="${publishersArray}" varStatus="status">
				<tr>
					<td>${publisher.publisherId}</td>
		            <td>${publisher.name}</td>
 		            <td>
 		            	<c:if test='${permissionsObject.publisherPermissions[status.index].update}'>
							<aui:form action="<%=editPublisherURL%>" name="<portlet:namespace/>fm">
								<aui:fieldset>
									<aui:input name="PublisherIndex" 
											value="${status.index}" type="hidden">
									</aui:input>
								</aui:fieldset>
								<aui:button type="submit" value="Edit"></aui:button>
							</aui:form>
						</c:if>
					</td>
					<td>
						<c:if test='${permissionsObject.publisherPermissions[status.index].delete}'>
							<aui:form action="<%=removePublisherURL%>" name="deleteForm${status.index}">
								<aui:fieldset>
									<aui:input name="PublisherIndex" 
											value="${status.index}" type="hidden">
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
		<aui:button onClick="<%= addPublisherFormURL.toString() %>" value="Add a publisher"></aui:button>
	</aui:button-row>
</c:if>