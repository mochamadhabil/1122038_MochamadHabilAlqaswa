/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UTS;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author abil
 */
public class User {

    private String userId;
    private String username;
    private String password;
    private String bio;
    private ArrayList<Post> posts = new ArrayList<Post>();

    public User(String userId, String username, String password, String bio, ArrayList<Post> posts) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.bio = bio;
        this.posts = posts;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    public void showUserPosts() {
        ArrayList<Post> userPosts = getPosts();
        StringBuilder hasil = new StringBuilder();

        for (int i = 0; i < userPosts.size(); i++) {
            Post post = userPosts.get(i);

            if (post.getStatus() == ContentState.PINNED) {
                hasil.append("PINNED POST:\n");
            }

            if (post instanceof Reel) {
                Reel reel = (Reel) post;
                hasil.append("Reel: Played Count - ").append(reel.getPlayedCount()).append("\n");
            } else if (post instanceof Story) {
                Story story = (Story) post;
                hasil.append("Story: Views - ").append(story.getViews()).append("\n");
            } else if (post instanceof Feed) {
                Feed feed = (Feed) post;
                hasil.append("Feed: Likes - ").append(feed.getLikes()).append("\n");
            }

            hasil.append("Post ID: ").append(post.getPostId()).append("\n");
            hasil.append("Status: ").append(post.getStatus()).append("\n");
            hasil.append("Time Upload: ").append(post.getTimeUpload()).append("\n");
            hasil.append("Type: ").append(post.getPostType()).append("\n");
            hasil.append("Comments: ").append(post.getComments().size()).append("\n");
            hasil.append("----------------------------------------\n");
        }

        JOptionPane.showMessageDialog(null, hasil.toString());
    }

    public void showPost(ArrayList<User> users, String postId) {
        boolean ditemukan = false;

        for (int i = 0; i < users.size() && !ditemukan; i++) {
            User user = users.get(i);
            ArrayList<Post> userPosts = user.getPosts();

            for (int j = 0; j < userPosts.size() && !ditemukan; j++) {
                Post post = userPosts.get(j);

                if (post.getPostId().equals(postId)) {
                    StringBuilder hasil = new StringBuilder();

                    if (post instanceof Reel) {
                        Reel reel = (Reel) post;
                        hasil.append("Reel Detail:\n");
                        hasil.append("Played Count: " + reel.getPlayedCount() + "\n");
                    } else if (post instanceof Story) {
                        Story story = (Story) post;
                        hasil.append("Story Detail:\n");
                        hasil.append("Views: " + story.getViews() + "\n");
                    } else if (post instanceof Feed) {
                        Feed feed = (Feed) post;
                        hasil.append("Feed Detail:\n");
                        hasil.append("Likes: " + feed.getLikes() + "\n");
                    }

                    hasil.append("Post ID: " + post.getPostId() + "\n");
                    hasil.append("Status: " + post.getStatus() + "\n");
                    hasil.append("Time Upload: " + post.getTimeUpload() + "\n");
                    hasil.append("Type: " + post.getPostType() + "\n");
                    hasil.append("Comments: " + post.getComments().size() + "\n");

                    JOptionPane.showMessageDialog(null, hasil.toString());
                    ditemukan = true;
                }
            }
        }

        if (!ditemukan) {
            JOptionPane.showMessageDialog(null, "Post dengan ID " + postId + " tidak ditemukan.");
        }
    }

    public void changePostState(String postId, ContentState statusBaru) {
        int numPosts = posts.size();
        int i = 0;
        boolean postFound = false;

        while (i < numPosts && !postFound) {
            Post post = posts.get(i);
            if (post.getPostId().equals(postId)) {
                ContentState currentStatus = post.getStatus();

                if (currentStatus == ContentState.SHOWED || currentStatus == ContentState.ARCHIVED) {
                    if (statusBaru == ContentState.ARCHIVED && currentStatus != ContentState.PINNED) {
                        post.setStatus(statusBaru);
                        JOptionPane.showMessageDialog(null, "Status Post dengan ID " + postId + " berhasil diubah menjadi ARCHIVED.");
                    } else if (statusBaru == ContentState.PINNED && currentStatus == ContentState.SHOWED) {
                        if (post instanceof Feed) {
                            post.setStatus(statusBaru);
                            JOptionPane.showMessageDialog(null, "Status Post dengan ID " + postId + " berhasil diubah menjadi PINNED.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Tidak dapat mengubah status menjadi PINNED. Batas Feed PINNED telah tercapai.");
                        }
                    } else if (statusBaru == ContentState.DELETED && currentStatus == ContentState.ARCHIVED) {
                        post.setStatus(statusBaru);
                        JOptionPane.showMessageDialog(null, "Status Post dengan ID " + postId + " berhasil diubah menjadi DELETED.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Perubahan status Post tidak diizinkan sesuai dengan aturan.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Perubahan status Post tidak diizinkan untuk status saat ini.");
                }

                postFound = true;
            }
            i++;
        }

        if (!postFound) {
            JOptionPane.showMessageDialog(null, "Post dengan ID " + postId + " tidak ditemukan.");
        }
    }
}
