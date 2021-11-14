const Sequelize = require('sequelize');
const db = require('../db.js');

const user = db.define('User', {
    id: { type: Sequelize.INTEGER, primaryKey: true, allowNull: false, autoIncrement: true },
    commodityName: { type: Sequelize.STRING(20), allowNull: false },
    commodityKind: { type: Sequelize.INTEGER, allowNull: false },
    // 1：书籍    2：电子产品   3：服装  4：纪念品  5：水果  6：文具  7：零食  8；其他
    commodityPrice: { type: Sequelize.STRING(20), allowNull: false },
    commodityPhoto: { type: Sequelize.STRING(255), allowNull: false },
    account: { type: Sequelize.STRING(20), allowNull:false },
    detail: { type: Sequelize.STRING(20), allowNull:false }
}, {
    underscored: true,
    tableName: 'commodities'
});

module.exports = user;