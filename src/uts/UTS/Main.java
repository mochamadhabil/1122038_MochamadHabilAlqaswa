/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UTS;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author abil
 */
public class Main {

    public static void dummy(ArrayList<Post> posts1) {
        ArrayList<Comment> comments1 = new ArrayList<Comment>();
        ArrayList<Comment> comments2 = new ArrayList<Comment>();
        ArrayList<Comment> comments3 = new ArrayList<Comment>();

        //Dummy buat Comments
        Comment comment1 = new Comment("112233", "Video yang bagus", ContentState.SHOWED);
        Comment comment2 = new Comment("113344", "foto yang bagus", ContentState.SHOWED);
        Comment comment3 = new Comment("114455", "Tema nya indah", ContentState.SHOWED);
        Comment comment4 = new Comment("115566", "Tema nya indah", ContentState.SHOWED);
        comments1.add(comment1);
        comments1.add(comment4);
        comments2.add(comment2);
        comments3.add(comment3);

        //Dummy buat Post
        Date timestamp = new Date();
        Post post1 = new Reel(30, 100, "1111", ContentState.SHOWED, timestamp, ContentType.VIDEO, comments1);
        Post post2 = new Story(30, 200, "1122", ContentState.DELETED, timestamp, ContentType.PICTURE, comments2);
        Post post3 = new Feed("Hari yang cerah ", 150, "1133", ContentState.ARCHIVED, timestamp, ContentType.PICTURE, comments3);
        Post post4 = new Story(30, 275, "1144", ContentState.SHOWED, timestamp, ContentType.VIDEO, comments3);
        posts1.add(post1);
        posts1.add(post2);
        posts1.add(post3);
        posts1.add(post4);

    }

    public static void main(String[] args) {
        Main mainClass = new Main();
        ArrayList<User> users = new ArrayList<User>();
        ArrayList<Post> posts1 = new ArrayList<Post>();
        dummy(posts1);

        User user = new User("101", "Mochamad Habil", "1234", "Still Jannah", posts1);
        users.add(user);

        Boolean menu = true;
        while (menu) {
            int pilihMenu = Integer.parseInt(JOptionPane.showInputDialog("Pilih Menu : \n1. Show User Post"
                    + " \n2. Show Post"
                    + " \n3. Change Post State"
                    + " \n4. Show User Best Post"
                    + " \n5. Exit")
            );

            switch (pilihMenu) {
                case 1:
                    user.showUserPosts();
                    break;
                case 2:
                    String idPost = "1122";
                    user.showPost(users, idPost);
                    break;
                case 3:
                    idPost = "1111";
                    user.changePostState(idPost, ContentState.ARCHIVED);
                    break;
                case 4:

                    break;
                case 5:
                    menu = false;
                    break;
            }
        }
    }
}
