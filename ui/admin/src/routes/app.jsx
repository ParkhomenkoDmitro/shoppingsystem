import UserProfile from "../views/UserProfile/UserProfile.jsx";

import {
    Person
} from "material-ui-icons";

const appRoutes = [
    {
        path: "/user",
        sidebarName: "User Profile",
        navbarName: "Profile",
        icon: Person,
        component: UserProfile
    }
];

export default appRoutes;