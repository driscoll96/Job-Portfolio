import { useState, useEffect, createContext } from 'react';
import { useLocation } from 'react-router-dom'
import { userContext } from '../../App'
import * as EnumService from "../../Services/EnumService";
import * as GiftService from "../../Services/Api/gift-api";
import ShowGiftsContainer from "../../Components/Gifts/ShowGiftsContainer";
import GiftFormOtherUserPage from "../../Components/Gifts/GiftFormOtherUserPage";
import * as UserService from "../../Services/Api/user-api";


export const reactionsContext = createContext();
export const otherUserContext = createContext();

export default function OtherProfilePage({ otherUser }) {

	const location = useLocation();
	const user = userContext.value;
	console.log("🚀 ~ file: OtherProfilePage.jsx ~ line 9 ~ OtherProfilePage ~ user", user)
	console.log("🚀 ~ file: OtherProfilePage.jsx ~ line 6 ~ OtherProfilePage ~ otherUser", otherUser)
	const [gifts, setGifts] = useState([]);
	const [showGifts, setShowGifts] = useState(false);
	const [reactions, setReactions] = useState({});

	useEffect(() => {
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

		const giftys = async (id) => {
			return await GiftService.getAllGiftsByUserId(otherUser.userId);
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
		otherUserContext.value = otherUser;
	}, [otherUser]);

	if (!showGifts) {
		return (
			<>
				<h2>loading...</h2>
			</>
		);
	}

	if (showGifts) {
		return (
			<>
				<otherUserContext.Provider value={otherUser}>
					<reactionsContext.Provider value={reactions}>
						<img src="../Zaluud.jpg" style={{ height: '10rem', width: '10rem', border: '5px solid black', borderRadius: '100px', background: 'white', margin: '1rem auto' }} />
						<h1>{otherUser.username}</h1>
						<GiftFormOtherUserPage />
						<ShowGiftsContainer gifts={gifts} />
					</reactionsContext.Provider>
				</otherUserContext.Provider>
			</>
		);
	}
}
