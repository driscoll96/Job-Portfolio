import React, { useEffect, useState, createContext } from "react";
import { userContext } from "../../App";
import ShowGiftsContainer from "../../Components/Gifts/ShowGiftsContainer";
import * as GiftService from "../../Services/Api/gift-api";
import * as UserService from "../../Services/Api/user-api";
import * as EnumService from "../../Services/EnumService";

export const reactionsContext = createContext();

export default function DashboardPage({ handleGetOtherUserProfile }) {
	const user = userContext.value;
	const [gifts, setGifts] = useState([]);
	const [showGifts, setShowGifts] = useState(false);
	const [reactions, setReactions] = useState({});
	const [updateGiftListOnTransfer, setupdateGiftListOnTransfer] = useState(false);
	const [updateAfterSendGift, setUpdateAfterSendGift] = useState(false);

	useEffect(() => {
		
		//getReactionEnums: Sets Reactions based on enums declared in the database.
		const getReactionEnums = async () => {
			const enums = await EnumService.getEnumKeysAndValues(
				"/profile/reactions"
			);
			enums[0].value = enums[0].value.replace(" ", "").split(",");
			enums[1].value = enums[1].value.replaceAll(" ", "").split(",");
			reactionsContext.value = enums;
			setReactions(enums);
		};
		getReactionEnums();

		//API call based on id
		const giftys = async (id) => {
			return await GiftService.getAllGiftsByUserId(user.userId);
		};

		const getRecipient = async (id) => {
			return await UserService.getUserById(id);
		};

		const attachy = async () => {
			const gifts = await giftys();
			let giftsWithRecipients = gifts.map(async (gift, idx) => {
				const recipient = await getRecipient(gift.recipientUserId);
				const gifter = await getRecipient(gift.gifterUserId);
				gift["recipient"] = recipient;
				gift["gifter"] = gifter;
				return gift;
			});
			giftsWithRecipients = await Promise.all(giftsWithRecipients);
			setGifts(giftsWithRecipients);
			setShowGifts(true);
		};

		attachy();
		setUpdateAfterSendGift(false);
	}, [user, updateAfterSendGift]);

	const updateGiftsOnGiftTransfer = () => {
		setupdateGiftListOnTransfer(!updateGiftListOnTransfer)
	}

	if (!showGifts) {
		return (
			<>
				<h2>loading...</h2>
			</>
		);
	}

	if (showGifts) {
		return (
			<div>
				<reactionsContext.Provider value={reactions}>
					<img src="scruffyburns.JPG" style={{ height: '10rem', width: '10rem', border: '5px solid black', borderRadius: '100px', background: 'white', margin: '1rem auto' }} />
					<h1>Welcome {user.username}</h1>
					<h2> You Currently Have {user.coinBalance} Dropsy Coins</h2>
					{/* <GiftFormDashboard user={user} setUpdateAfterSendGift={setUpdateAfterSendGift} /> */}
					<ShowGiftsContainer handleGetOtherUserProfile={handleGetOtherUserProfile} setUpdateAfterSendGift={setUpdateAfterSendGift} gifts={gifts} />
				</reactionsContext.Provider>
			</div>
		);
	}

};