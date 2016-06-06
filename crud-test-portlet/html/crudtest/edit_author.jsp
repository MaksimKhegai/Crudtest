<%@ include file="/html/crudtest/init.jsp"%>
<%@ include file="/html/crudtest/popup.jsp" %>

<portlet:actionURL name="updateAuthor" var="updateAuthorURL"></portlet:actionURL>
<portlet:actionURL name="removeAuthor" var="removeAuthorURL"></portlet:actionURL>

<aui:form action="<%=updateAuthorURL%>" name="<portlet:namespace/>fm">
	<aui:fieldset>
		<aui:input label="Name" name="Name"
			value="${authorsArray[currentAuthorIndex].name}">
			<aui:validator name="required" errorMessage="Please enter name of the author." />
		</aui:input>
		<aui:input label="Birth date" name="BirthDate"
			value="${authorsArray[currentAuthorIndex].birthDate}">
			<aui:validator name="required" errorMessage="Please enter a valid date."/>
		    <aui:validator name="date"/>
		</aui:input>
		<aui:input name="AuthorIndex" value="${currentAuthorIndex}"
			type="hidden"></aui:input>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" value="Save"></aui:button>
		<aui:button onClick="<%= showAuthorsURL %>" value="Back"></aui:button>
	</aui:button-row>
</aui:form>

<c:if test='${permissionsObject.globalPermissions.add}'>
	<aui:form action="<%=removeAuthorURL%>"
		name="deleteForm${currentAuthorIndex}">
		<aui:fieldset>
			<aui:input name="AuthorIndex" value="${currentAuthorIndex}"
				type="hidden">
			</aui:input>
		</aui:fieldset>
		<aui:button style="color:red"
			onClick="javascript:showConfirmation(${currentAuthorIndex})"
			value="Delete"></aui:button>
	</aui:form>
</c:if>