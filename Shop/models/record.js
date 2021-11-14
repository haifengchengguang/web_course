const Sequelize = require('sequelize');
const db = require('../db.js');

const user = db.define('User', {
    id: { type: Sequelize.INTEGER, primaryKey: true, allowNull: false, autoIncrement: true },
    studentId: { type: Sequelize.STRING(20), allowNull: false },
    commodityName: { type: Sequelize.STRING(20), allowNull: false },
    commodityPrice: { type: Sequelize.STRING(20), allowNull: false },
    commodityPhoto: { type: Sequelize.STRING(255), allowNull: false },
    commodityId: { type: Sequelize.INTEGER, allowNull: false }
}, {
    underscored: true,
    tableName: 'records'
});

module.exports = user;