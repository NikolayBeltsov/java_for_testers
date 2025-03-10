package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupRemovalTests extends TestBase {

    @Test
    public void canRemoveGroup() {
        //Открываем страницу с группами
        app.openGroupsPage();
        //Если нет группы, то создается новая
        if (!app.isGroupPresent()) {
            app.createGroup(new GroupData("group name", "group header", "group footer"));
        }
        //Удаляем группу
        app.removeGroup();

    }

}
