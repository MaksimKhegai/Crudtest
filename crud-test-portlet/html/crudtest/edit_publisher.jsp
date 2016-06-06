<%@ include file="/html/crudtest/init.jsp"%>
<%@ include file="/html/crudtest/popup.jsp" %>

<portlet:actionURL name="updatePublisher" var="updatePublisherURL"></portlet:actionURL>
<portlet:actionURL name="removePublisher" var="removePublisherURL"></portlet:actionURL>

<aui:form action="<%=updatePublisherURL%>" name="<portlet:namespace/>fm">
	<aui:fieldset>
		<aui:input label="Name" name="Name"
			value="${publishersArray[currentPublisherIndex].name}">
				<aui:validator name="required" errorMessage="Please enter name of the publisher." />
			</aui:input>
		<aui:input name="PublisherIndex" value="${currentPublisherIndex}"
			type="hidden"></aui:input>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" value="Save"></aui:button>
		<aui:button onClick="<%= showPublishersURL %>" value="Back"></aui:button>
	</aui:button-row>
</aui:form>

<c:if test='${permissionsObject.globalPermissions.add}'>
	<aui:form action="<%=removePublisherURL%>"
		name="deleteForm${currentPublisherIndex}">
		<aui:fieldset>
			<aui:input name="PublisherIndex" value="${currentPublisherIndex}"
				type="hidden">
			</aui:input>
		</aui:fieldset>
		<aui:button style="color:red" 
			onClick="javascript:showConfirmation(${currentPublisherIndex})"
			value="Delete">
		</aui:button>
	</aui:form>
</c:if>