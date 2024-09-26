<%@ taglib uri = "/struts-tags" prefix="s" %>
<html>
<head>
    <title>Add task</title>
</head>
<body>
    <h2>Add task</title>
    <s:form action="add" method="post">
        <s:textfield name="title" label="Title"/>
        <s:textfield name="description" label="Description"/>
        <s:textfield name="status" label="Status"/>
        <s:submit value="Add"/>
    </s:form>

</body>
</html>