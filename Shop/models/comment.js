const Sequelize = require('sequelize');
const db = require('../db.js');

const user = db.define('User', {
    id: { type: Sequelize.INTEGER, primaryKey: true, allowNull: false, autoIncrement: true },
    studentName: { type: Sequelize.STRING(20), allowNull: false },
    commodityId: { type: Sequelize.INTEGER, allowNull: false },
    talk: { type: Sequelize.STRING(20), allowNull: false }
}, {
    underscored: true,
    tableName: 'comments'
});

module.exports = user;