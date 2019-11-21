package com.design.onlinemovieticketbooking.entity;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.design.onlinemovieticketbooking.Booking;
import com.design.onlinemovieticketbooking.pojo.ShowSeat;

public class Customer extends Person {
	public boolean makeBooking(Booking booking) {
		List<ShowSeat> seats = booking.getSeats();
		Integer seatIds[] = new Integer[seats.size()];
		int index = 0;
		for (ShowSeat seat : seats) {
			seatIds[index++] = seat.getShowSeatId();
		}

		Connection dbConnection = null;
		try {
			dbConnection = getDBConnection();
			dbConnection.setAutoCommit(false);
			// ‘Serializable’ is the highest isolation level and guarantees safety from
			// Dirty, Nonrepeatable, and Phantoms reads
			dbConnection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

			Statement st = dbConnection.createStatement();
			String selectSQL = "Select * From ShowSeat where ShowID=? && ShowSeatID in (?) && isReserved=0";
			PreparedStatement preparedStatement = dbConnection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, booking.getShow().getShowId());
			Array array = dbConnection.createArrayOf("INTEGER", seatIds);
			preparedStatement.setArray(2, array);

			ResultSet rs = preparedStatement.executeQuery();
			// With TRANSACTION_SERIALIZABLE all the read rows will have the write lock, so
			// we can
			// safely assume that no one else is modifying them.
			if (rs.next()) {
				rs.last(); // move to the last row, to calculate the row count
				int rowCount = rs.getRow();
				// check if we have expected number of rows, if not, this means another process
				// is
				// trying to process at least one of the same row, if that is the case we
				// should not process this booking.
				if (rowCount == seats.size()) {
					// update ShowSeat table...
					// update Booking table ...
					dbConnection.commit();
					return true;
				}
			}
		} catch (SQLException e) {
			try {
				dbConnection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println(e.getMessage());
		}
		return false;

	}

	private Connection getDBConnection() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Booking> getBookings() {
		return null;

	}
}
