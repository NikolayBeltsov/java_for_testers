package tests;

import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GroupRemovalTests extends TestBase {

    @Test
    public void canRemoveGroup() {
        //Если нет группы, то создается новая
        if (app.groups().getCount() == 0) {
            app.groups().createGroup(new GroupData("group name", "group header", "group footer"));
        }
        int groupCount = app.groups().getCount();
        //Удаляем группу
        app.groups().removeGroup();
        int newgroupCount = app.groups().getCount();
        Assertions.assertEquals(groupCount - 1, newgroupCount);

    }

    @Test

    void canRemoveAllGroupsAtOnce() {
        //Если нет группы, то создается новая
        if (app.groups().getCount() == 0) {
            app.groups().createGroup(new GroupData("group name", "group header", "group footer"));
        }
        app.groups().removeAllGroups();
        Assertions.assertEquals(0, app.groups().getCount());
    }

}
