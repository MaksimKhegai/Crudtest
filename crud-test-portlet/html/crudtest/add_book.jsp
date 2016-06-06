<%@ include file="/html/crudtest/init.jsp"%>

<portlet:actionURL name="addBook" var="addBookURL"></portlet:actionURL>

<aui:form action="<%=addBookURL%>" name="<portlet:namespace/>fm">
	<aui:fieldset>
		<aui:input label="Name" name="Name">
			<aui:validator name="required"
				errorMessage="Please enter name of the book." />
		</aui:input>
		<aui:select label="Genre" name="Genre">
			<c:forEach var="genre" begin="0" items="${genresArray}"
				varStatus="status">
				<aui:option value="${genre.genreId}">${genre.name}</aui:option>
			</c:forEach>
		</aui:select>
		<aui:select label="Author" name="Author">
			<c:forEach var="author" begin="0" items="${authorsArray}"
				varStatus="status">
				<aui:option value="${author.authorId}">${author.name}</aui:option>
			</c:forEach>
		</aui:select>
		<aui:select label="Publisher" name="Publisher">
			<c:forEach var="publisher" begin="0" items="${publishersArray}"
				varStatus="status">
				<aui:option value="${publisher.publisherId}">${publisher.name}</aui:option>
			</c:forEach>
		</aui:select>
		<aui:input label="Release date" name="ReleaseDate">
			<aui:validator name="required"
				errorMessage="Please enter a valid date." />
			<aui:validator name="date" />
		</aui:input>
		
		<aui:field-wrapper label="permissions">
			<liferay-ui:input-permissions
				modelName="<%= Book.class.getName() %>"
			/>
		</aui:field-wrapper>
		
	</aui:fieldset>
	
	<aui:button-row>
		<aui:button type="submit" value="Add"></aui:button>
		<aui:button onClick="<%= showBooksURL %>" value="Back"></aui:button>
	</aui:button-row>
</aui:form>