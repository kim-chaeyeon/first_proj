package org.example.dao;

import org.example.container.Container;
import org.example.dto.Information;
import org.example.db.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;


public class InformationDao extends Dao {
    private DBConnection dbConnection;
    private List<Information> informations; // 정보를 저장할 리스트

    public InformationDao() {
        dbConnection = Container.getDBConnection();
        informations = new ArrayList<>(); // 초기화
    }

    public void write(Information information) {
        String sql = String.format("INSERT INTO information (regDate, memberId, name, sex, age, major, phoneNumber, mbti, snsId, appeal) VALUES ('%s', %d, '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')",
                information.regDate, information.memberId, information.name, information.sex, information.age, information.major, information.phoneNumber, information.mbti, information.snsId, information.appeal);

        int id = dbConnection.insert(sql);
        information.id = id;
        lastId = id;
    }

    public List<Information> getInformationsBySex(String sex) {
        String sql = "SELECT * FROM information WHERE sex = ?";
        List<Information> informations = new ArrayList<>();

        try (PreparedStatement pstmt = dbConnection.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, sex);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Information information = new Information(
                        rs.getInt("id"),
                        rs.getString("regDate"),
                        rs.getInt("memberId"),
                        rs.getString("name"),
                        rs.getString("sex"),
                        rs.getString("age"),
                        rs.getString("major"),
                        rs.getString("phoneNumber"),
                        rs.getString("mbti"),
                        rs.getString("snsId"),
                        rs.getString("appeal")
                );
                informations.add(information);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return informations;
    }

    private int getInformationIndexById(int id) {
        int i = 0;

        for (Information information : informations) {
            if (information.id == id) {
                return i;
            }
            i++;
        }

        return -1;
    }

    public Information getInformationById(int id) {
        int index = getInformationIndexById(id);

        if (index != -1) {
            return informations.get(index);
        }

        return null;
    }

    public List<Information> getForPrintInformations(String searchKeyword) {
        if (searchKeyword != null && searchKeyword.length() != 0) {
            List<Information> forListInformations = new ArrayList<>();

            for (Information information : informations) {
                if (information.name.contains(searchKeyword)) {
                    forListInformations.add(information);
                }
            }

            return forListInformations;
        }

        return informations;
    }

    public void remove(Information foundInformation) {
        informations.remove(foundInformation);
    }

    public void deleteInformation(int informationId) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBConnection.getConnection();
            String sql = "DELETE FROM information WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, informationId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
