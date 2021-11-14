const Sequelize = require('sequelize');
const db = require('../db.js');

const user = db.define('User', {
    id: { type: Sequelize.INTEGER, primaryKey: true, allowNull: false, autoIncrement: true },
    tel: { type: Sequelize.STRING(20), allowNull: false },
    studentName: { type: Sequelize.STRING(20), allowNull: false },
    account: { type: Sequelize.STRING(20), allowNull: false },
    password: { type: Sequelize.STRING(20), allowNull: false }
}, {
    underscored: true,
    tableName: 'users'
});

module.exports = user;