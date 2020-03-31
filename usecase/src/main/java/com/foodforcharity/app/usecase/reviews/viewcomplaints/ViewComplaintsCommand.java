package com.foodforcharity.app.usecase.reviews.viewcomplaints;

import java.util.List;
import java.util.Optional;

import com.foodforcharity.app.mediator.Command;

public class ViewComplaintsCommand implements Command<Void> {
	long personId; // required to decide which complaints to show based on who the person is
	Optional<List<Filter>> filters;

	enum Filter {
		Donors, Donees, Status
	}

	public ViewComplaintsCommand() {

	}

	/**
	 * Public constructors
	 * 
	 * @param personId
	 */
	public ViewComplaintsCommand(long personId) {
		this.personId = personId;
		filters = Optional.empty();
	}

	/**
	 * 
	 * @param filters
	 */
	public void setFilters(List<Filter> filters) {
		this.filters = Optional.of(filters);
	}

}