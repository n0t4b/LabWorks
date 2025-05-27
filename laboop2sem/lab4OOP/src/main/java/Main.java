import models.Auto;
import models.User;
import services.UserService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();

        User user = new User("Misha", 30);
        userService.saveUser(user);

        Auto ferrari = new Auto("Ferrari 360 Spider", "red");
        ferrari.setUser(user);
        user.addAuto(ferrari);

        Auto ford = new Auto("Ford Focus", "black");
        ford.setUser(user);
        user.addAuto(ford);

        userService.updateUser(user);

        User user2 = userService.findUser(user.getId());
        List<Auto> user2Autos = user2.getAutos();
        for (Auto auto : user2Autos) {
            System.out.println(auto);
        }

        user.setName("Sasha");
        userService.updateUser(user);

        userService.deleteUser(user);
    }
}