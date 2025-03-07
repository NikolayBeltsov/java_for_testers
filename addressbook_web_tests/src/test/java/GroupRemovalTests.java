import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupRemovalTests extends TestBase {

    @Test
    public void canRemoveGroup() {
        //Открываем страницу с группами
        openGroupsPage();
        //Если нет группы, то создается новая
        if (!isGroupPresent()) {
            createGroup(new GroupData("group name", "group header", "group footer"));
        }
        //Удаляем группу
        removeGroup();

    }

}
