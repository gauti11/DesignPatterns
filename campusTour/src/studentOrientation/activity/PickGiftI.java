package studentOrientation.activity;

import studentOrientation.activity.PickGift.PickGiftPlaces;

public interface PickGiftI {
	/**
	 * This method will calculate all the effort required to perform the current Activity.
	 * @param giftPlaceIn the enum of PickGiftPlaces
	 */
	void getTotalEffortForPickingGift(PickGiftPlaces giftPlaceIn);
}
