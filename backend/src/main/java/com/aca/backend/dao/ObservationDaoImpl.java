package com.aca.backend.dao;

import com.aca.backend.model.Chapter;
import com.aca.backend.model.Observation;
import com.aca.backend.model.ObservationType;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ObservationDaoImpl implements ObservationDao {

    private static String selectAllObservations =
            "SELECT id, text, typeId, createDateTime, updateDateTime " +
            "FROM observations";
    private static String selectObservationsByType =
            "SELECT id, text, typeId, createDateTime, updateDateTime " +
            "FROM observations " +
            "WHERE typeId = ? ";
    private static String selectObservationsById =
            "SELECT id, text, typeId, createDateTime, updateDateTime " +
            "FROM observations " +
            "WHERE id = ? ";
    private static String selectObservationsByDay =
            "SELECT id, text, typeId, createDateTime, updateDateTime " +
            "FROM observations " +
            "WHERE DATE(createDateTime) = ? ";
    private static String insertObservation =
            "INSERT INTO observations (text, typeId) " +
            "VALUES " +
            "('This is a new spiritual observation', 'Spiritual')" ;
    private static String updateObservationsById =
            "UPDATE observations " +
            "SET text = 'This is now a moral observation', " +
                "typeId = 'Moral' " +
                "WHERE id = 3 ";
    private static String deleteObservationById =
            "DELETE FROM observations " +
            "WHERE id = ? ";


    private List<Observation> makeObservations(ResultSet result) throws SQLException {
        List<Observation> observations = new ArrayList<>();
        while(result.next()) {
            Observation observation = new Observation();
            observation.setId(result.getInt("id"));
            observation.setText(result.getString("text"));

            String typeString = result.getString("typeId");
            observation.setType(ObservationType.convertStringToObType(typeString));

            observation.setCreateDateTime(result.getObject("createDateTime", LocalDate.class));
            observation.setUpdateDateTime(result.getObject("updateDateTime", LocalDate.class));

            observations.add(observation);
        }

        return observations;
    }

    @Override
    public List<Observation> getObservations() {
        List<Observation> myObservations = new ArrayList<>();
        ResultSet rs = null; // an object that contains the rows and columns
        Statement s = null; // what we build and send

        Connection connection = MariaDbUtil.getConnection();

        try {
            s = connection.createStatement();
            rs = s.executeQuery(selectAllObservations);
            myObservations = makeObservations(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return myObservations;
    }

    @Override
    public List<Observation> getObservationsByType(ObservationType observationType) {
        List<Observation> myObservations = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;

        Connection conn = MariaDbUtil.getConnection();
        try {
            ps = conn.prepareStatement(selectObservationsByType);
            ps.setString(1, observationType.toString());
            rs = ps.executeQuery();
            myObservations = makeObservations(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return myObservations;
    }

    @Override
    public List<Observation> getObservationsById(Integer observationId) {
        List<Observation> myObservations = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;

        Connection conn = MariaDbUtil.getConnection();
        try {
            ps = conn.prepareStatement(selectObservationsById);
            ps.setInt(1,observationId);
            rs = ps.executeQuery();
            myObservations = makeObservations(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return myObservations;
    }

    @Override
    public List<Observation> getObservationsByDay(LocalDate dateCreated) {
        List<Observation> myObservations = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;

        Connection conn = MariaDbUtil.getConnection();
        try {
            java.sql.Date date = java.sql.Date.valueOf(dateCreated);
            ps = conn.prepareStatement(selectObservationsByDay);
            ps.setDate(1,date);
            rs = ps.executeQuery();
            myObservations = makeObservations(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return myObservations;
    }

    @Override
    public Observation createObservation(Observation newObservation) {
        PreparedStatement ps = null;
        Connection conn = MariaDbUtil.getConnection();

        try {
            ps = conn.prepareStatement(insertObservation);
            ps.setString(1, newObservation.getText());
            ps.setString(2, newObservation.getType().toString());
            int rowCount = ps.executeUpdate();
            System.out.println("inser count: " + rowCount);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return newObservation;
    }


    @Override
    public Observation updateObservation(Observation updateObservation) {
        List<Observation> myObservations = this.getObservationsById(updateObservation.getId());

        if (myObservations.size() > 0) {
            PreparedStatement ps = null;
            Connection conn = MariaDbUtil.getConnection();
            try {
                ps = conn.prepareStatement(updateObservationsById);
                ps.setString(1, updateObservation.getText());
                ps.setString(2, updateObservation.getType().toString());
                ps.setInt(3, updateObservation.getId());
                int rowCount = ps.executeUpdate();
                System.out.println("rows updated: " + rowCount);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return updateObservation;
    }

    @Override
    public Observation deleteObservationById(Integer observationIdValue) {
        List<Observation> myObservations = getObservationsById(observationIdValue);
        Observation observationToDelete = null;

        if (myObservations.size() > 0) {
            observationToDelete = myObservations.get(0);
            PreparedStatement ps = null;

            Connection conn = MariaDbUtil.getConnection();
            try {
                ps = conn.prepareStatement(deleteObservationById);
                ps.setInt(1, observationIdValue);
                int rowCount = ps.executeUpdate();
                System.out.println("rows deleted: " + rowCount);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return observationToDelete;
        }

    }

    // TODO: getObservationsByBook()
    // TODO: getObservationsByChapter()