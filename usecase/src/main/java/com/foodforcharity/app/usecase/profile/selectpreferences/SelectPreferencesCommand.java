package com.foodforcharity.app.usecase.profile.selectpreferences;

import java.util.List;
import java.util.Optional;

import com.foodforcharity.app.mediator.Command;

public class SelectPreferencesCommand implements Command<Void> {
	long doneeId;
	Optional<Range> spiceRange;
	Optional<List<Integer>> allergenIds;
	Optional<Range> priceRange;
	Optional<List<Integer>> cuisineIds;
	Optional<List<Integer>> mealTypeIds;

	public SelectPreferencesCommand() {

	}

	public class Range {
		int start;
		int stop;

		public Range(int start, int stop) {
			this.start = start;
			this.stop = stop;
		}

	}
}