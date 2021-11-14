const express = require('express');
const User = require('../models/user.js');
const Commodity = require('../models/commodity.js');
const Like = require('../models/like.js');
const Comment = require('../models/comment.js');
const Record = require('../models/record.js');

const router = express.Router();

router.get('/', function(req, res) {
  res.redirect('/login');
});

router.get('/login', (req, res) => {
  res.render('login.html');
});

router.get('/register', (req, res) => {
  res.render('register.html');
});

router.post('/register', (req, res) => {
  let body = req.body;
  User.create({
    tel: body.tel,
    studentName: body.studentName,
    account: body.account,
    password: body.password
  }).then(() => {
    res.redirect('/login');
  });
});

router.post('/login', (req, res) => {
  let body = req.body;
  User.findAll({
    where: {
      account: body.account,
      password: body.password
    }
  }).then( users => {
    if(users.length !== 0){
      res.redirect('/index?account=' + body.account);
    }else{
      res.redirect('/login');
    }
  });
});

router.get('/index', (req, res) => {
  let account = req.query.account;
  res.render('index.html', {
    account: account
  });
});

router.get('/upload', (req, res) => {
  let account = req.query.account;
  res.render('upload.html', {
    account: account
  })
});

// 添加商品
router.post('/upload', (req, res) => {
  let body = req.body;
  Commodity.create({
    commodityName: body.commodityName,
    commodityKind: body.commodityKind,
    commodityPrice: body.commodityPrice,
    commodityPhoto: body.commodityPhoto,
    detail: body.detail,
    account: body.account
  }).then(() => {
    res.redirect('/index?account=' + body.account);
  })
});

router.get('/book', (req, res) => {
  Commodity.findAll({
    where: {
      commodityKind: 1
    }
  }).then( books => {
    res.render('book.html', {
      account: req.query.account,
      books: books
    });
  });
});

router.get('/electronic', (req, res) => {
  Commodity.findAll({
    where: {
      commodityKind: 2
    }
  }).then( electronicProducts => {
    res.render('electronic.html', {
      account: req.query.account,
      electronicProducts: electronicProducts
    });
  });
});

router.get('/clothes', (req, res) => {
  Commodity.findAll({
    where: {
      commodityKind: 3
    }
  }).then( clothes => {
    res.render('clothes.html', {
      account: req.query.account,
      clothes: clothes
    });
  });
});

router.get('/others', (req, res) => {
  Commodity.findAll({
    where: {
      commodityKind: 4
    }
  }).then( commodities => {
    res.render('others.html', {
      account: req.query.account,
      commodities: commodities
    });
  });
});

// 卖家商品管理界面
router.get('/manage', (req, res) => {
  Commodity.findAll({
    where: {
      account: req.query.account
    }
  }).then( commodities => {
    res.render('manage.html', {
      account: req.query.account,
      commodities: commodities
    });
  });
});

// 下架商品
router.get('/delete', (req, res) => {
  Commodity.destroy({
    where: {
      id: req.query.id
    }
  }).then(() => {
    res.redirect('/manage?account=' + req.query.account)
  })
});

// 商品详情界面
router.get('/commodity', (req, res) => {
  Commodity.findAll({
    where: {
      id: req.query.id
    }
  }).then( commodities => {
    User.findAll({
      where: {
        account: commodities[0].account
      }
    }).then( students => {
      Comment.findAll({
        where: {
          commodityId: req.query.id
        }
      }).then(comments => {
        res.render('detail.html', {
          commodityName: commodities[0].commodityName,
          commodityPrice: commodities[0].commodityPrice,
          commodityPhoto: commodities[0].commodityPhoto,
          detail: commodities[0].detail,
          tel: students[0].tel,
          studentName: students[0].studentName,
          account: req.query.account,
          id: req.query.id,
          comments: comments
        });
      });

    });
  });
});

// 收藏按钮
router.get('/star', (req, res) => {
  let account = req.query.account, id = req.query.id;
  Like.findAll({
    where: {
      studentId: account,
      commodityId: id
    }
  }).then(likes => {
    if (likes.length === 0){
      Commodity.findAll({
        where: {
          id: id
        }
      }).then(commodities => {
        Like.create({
          studentId: account,
          commodityId: id,
          commodityName: commodities[0].commodityName,
          commodityPrice: commodities[0].commodityPrice,
          commodityPhoto: commodities[0].commodityPhoto
        }).then(() => {
          res.redirect('/commodity?account=' + account + '&id=' + id);
        });
      });
    }else{
      res.redirect('/commodity?account=' + account + '&id=' + id);
    }
  });
});

// 查看收藏夹
router.get('/like', (req, res) => {
  let account = req.query.account;
  Like.findAll({
    where: {
      studentId: account
    }
  }).then(commodities => {
    res.render('like.html', {
      account: req.query.account,
      commodities: commodities
    });
  });
});

// 搜索结果
router.post('/search', (req, res) => {
  let account = req.body.account, content = req.body.content;
  Commodity.findAll({
    where: {
      commodityName: content
    }
  }).then(commodities => {
    res.render('search.html', {
      account: account,
      commodities: commodities
    });
  });
});

// 取消收藏
router.get('/dislike', (req, res) => {
  let account = req.query.account, id = req.query.id;
  Like.destroy({
    where: {
      commodityId: id
    }
  }).then(() => {
    res.redirect('/like?account=' + account);
  });
});

// 修改密码
router.get('/password', (req, res) => {
  let account = req.query.account;
  res.render('password.html', {
    account: account
  });
});

// 修改密码
router.post('/password', (req, res) => {
  User.update({
    password: req.body.password
  }, {
    where: {
      account: req.body.account
    }
  }).then(() => {
    res.redirect('/index?account=' + req.body.account);
  });
});

// 添加评论
router.post('/comment', (req, res) => {
  let account = req.body.account, id = req.body.id, talk = req.body.talk;
  User.findAll({
    where: {
      account: account
    }
  }).then(students => {
    Comment.create({
      studentName: students[0].studentName,
      commodityId: id,
      talk: talk
    }).then(() => {
      res.redirect('/commodity?account=' + account + '&id=' + id);
    });
  });
});

// 购买按钮
router.get('/buy', (req, res) => {
  let account = req.query.account, id = req.query.id;
  Record.findAll({
    where: {
      studentId: account,
      commodityId: id
    }
  }).then(records => {
    if (records.length === 0){
      Commodity.findAll({
        where: {
          id: id
        }
      }).then(commodities => {
        Record.create({
          studentId: account,
          commodityId: id,
          commodityName: commodities[0].commodityName,
          commodityPrice: commodities[0].commodityPrice,
          commodityPhoto: commodities[0].commodityPhoto
        }).then(() => {
          res.redirect('/commodity?account=' + account + '&id=' + id);
        });
      });
    }else{
      res.redirect('/commodity?account=' + account + '&id=' + id);
    }
  });
});

// 购买记录
router.get('/record', (req, res) => {
  let account = req.query.account;
  Record.findAll({
    where: {
      studentId: account
    }
  }).then(commodities => {
    res.render('record.html', {
      account: req.query.account,
      commodities: commodities
    });
  });
});

// 校车
router.get('/bus', (req, res) => {
  let account = req.query.account;
  res.render('extra/bus.html', {
    account: account
  });
});

// 课表
router.get('/course', (req, res) => {
  let account = req.query.account;
  res.render('extra/timeofclass.html', {
    account: account
  });
});

// 校历
router.get('/calendar', (req, res) => {
  let account = req.query.account;
  res.render('extra/calendar.html', {
    account: account
  });
});

// 周一
router.get('/room1', (req, res) => {
  let account = req.query.account;
  res.render('extra/room1.html', {
    account: account
  });
});

// 周二
router.get('/room2', (req, res) => {
  let account = req.query.account;
  res.render('extra/room2.html', {
    account: account
  });
});

// 周三
router.get('/room3', (req, res) => {
  let account = req.query.account;
  res.render('extra/room3.html', {
    account: account
  });
});

// 周四
router.get('/room4', (req, res) => {
  let account = req.query.account;
  res.render('extra/room4.html', {
    account: account
  });
});

// 周五
router.get('/room5', (req, res) => {
  let account = req.query.account;
  res.render('extra/room5.html', {
    account: account
  });
});


module.exports = router;
