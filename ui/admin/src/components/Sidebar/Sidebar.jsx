import React from 'react';
import PropTypes from "prop-types";
import cx from "classnames";
import {
    withStyles,
    Drawer,
    Hidden,
    List,
    ListItem,
    ListItemIcon,
    ListItemText
} from "material-ui";

import sidebarStyle from "../../variables/styles/sidebarStyle.jsx";
import {NavLink} from 'react-router-dom';

const Sidebar = ({ ...props }) => {

    function activeRoute(routeName) {
        return props.location.pathname.indexOf(routeName) > -1 ? true : false;
    }

    const { classes, color, logo, image, logoText, routes } = props;

    var links = (
        <List className={classes.list}>
            {routes.map((prop, key) => {
                if (prop.redirect) {
                    return null;
                }

                const listItemClasses = cx({
                    [" " + classes[color]]: activeRoute(prop.path)
                });

                const whiteFontClasses = cx({
                    [" " + classes.whiteFont]: activeRoute(prop.path)
                });

                return (
                    <NavLink
                        to={prop.path}
                        className={classes.item}
                        activeClassName="active"
                        key={key}
                    >
                        <ListItem button className={classes.itemLink + listItemClasses}>
                            <ListItemIcon className={classes.itemIcon + whiteFontClasses}>
                                <prop.icon />
                            </ListItemIcon>
                            <ListItemText
                                primary={prop.sidebarName}
                                className={classes.itemText + whiteFontClasses}
                                disableTypography={true}
                            />
                        </ListItem>
                    </NavLink>
                );
            })}
        </List>
    );

    return (
        <div>
            <Drawer
                anchor="left"
                variant="permanent"
                open
                classes={{
                    paper: classes.drawerPaper
                }}
            >
                {/*{brand}*/}
                <div className={classes.sidebarWrapper}>{links}</div>
                {image !== undefined ? (
                    <div
                        className={classes.background}
                        style={{ backgroundImage: "url(" + image + ")" }}
                    />
                ) : null}
            </Drawer>
        </div>
    );
};

Sidebar.propTypes = {
    classes: PropTypes.object.isRequired
};

export default withStyles(sidebarStyle)(Sidebar);