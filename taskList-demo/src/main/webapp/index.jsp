<%@ taglib uri = "/struts-tags" prefix="s" %>
<html>
    <head>
        <title> TASK LIST </title>
    </head>
<body>
    <h2>Task list</h2>
    <table border="1">
        <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
        </tr>
        <s:iterator value="taskList">
                <tr>
                    <td><s:property value="id"/></td>
                    <td><s:property value="title"/></td>
                    <td><s:property value="description"/></td>
                    <td><s:property value="status"/></td>
                    <td>
                        <a href="editTask?id=<s:property value='id'/>">Edit</a>
                        <a href="deleteTask?id=<s:property value='id'/>">Delete</a>
                    </td>
                </tr>
            </s:iterator>
    </table>
    <a href="add">Add task</a>
</body>
</html>