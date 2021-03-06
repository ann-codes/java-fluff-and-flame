
INSERT INTO creature_types(type, description, img_url)
VALUES
  (
    'Unicorn',
    'A equine animal, typically with white fur, easily identifed by a large horn on their heads.',
    'https://i.imgur.com/aQ7YyVW.jpg'
  ),
  (
    'Chimera',
    'A fire-breathing monster with a lion head, goat body, and a serpent tail.',
    'https://i.imgur.com/7y2M1yY.jpg'
  ),
  (
    'Kelpi',
    'A shape-shifting water spirit inhabiting the lochs and pools of Scotland.',
    'https://i.quotev.com/img/q/u/17/10/12/jzdw4y5vue.jpg'
  ),
  (
    'Phoenix',
    'A phoenix is a long-lived bird that cyclically regenerates or is otherwise born again.',
    'https://i.imgur.com/StnBqkP.jpg'
  );
INSERT INTO adoptable_creatures(
    name,
    creature_img,
    age,
    vaccination_status,
    adoption_story,
    adoption_status,
    type_id
  )
VALUES
  (
    'Taco Cat',
    'https://i.pinimg.com/originals/af/60/ea/af60ea38d3ff1f9c940ed7540e6b4e9e.jpg',
    17,
    'no',
    'A Nyan cat in the shape of a taco. Yummmmmmm.',
    'available',
    (SELECT id FROM creature_types WHERE type='Nyan Cat')
  ),(
    'Toast',
    'https://media.giphy.com/media/1135FPdT0iGkDK/giphy.gif',
    8,
    'yes',
    'TOAST CAT',
    'available',
    (SELECT id FROM creature_types WHERE type='Nyan Cat')
  ),(
    'Liddy Kiddy',
    'https://media1.tenor.com/images/aae006222ffe56fa053e66521319010c/tenor.gif',
    8,
    'yes',
    'Happy Saint Paddys Day',
    'available',
    (SELECT id FROM creature_types WHERE type='Nyan Cat')
  ),
  (
    'Spyro',
    'https://i.kym-cdn.com/photos/images/original/001/378/444/bb6.jpg',
    950,
    'yes',
    'Fought many a battle now needs a happy home',
    'available',
    (SELECT id FROM creature_types WHERE type='Dragon')
  ),(
    'Deathwing',
    'https://gamepedia.cursecdn.com/wowpedia/thumb/2/27/Glowei_Deathwing.jpg/808px-Glowei_Deathwing.jpg',
    6950,
    'yes',
    'One of the five Dragon Aspects and leader of the black dragonflight.',
    'available',
    (SELECT id FROM creature_types WHERE type='Dragon')
  ),
  (
    'Alexstrasza',
    'https://gamepedia.cursecdn.com/wowpedia/5/55/Alexstrasza_in_Twilight_Highlands.jpg',
    7809,
    'yes',
    'Alexstrasza the Life-Binder, Aspect of the red dragonflight, is the guardian of all life in the world of Azeroth.',
    'available',
    (SELECT id FROM creature_types WHERE type='Dragon')
  ),(
    'Yoshi',
    'https://www.mariowiki.com/images/thumb/4/4d/Yoshi_-_Mario_Party_10.png/784px-Yoshi_-_Mario_Party_10.png',
    38,
    'yes',
    'Is really a dinosaur, but whatever',
    'available',
    (SELECT id FROM creature_types WHERE type='Dragon')
  ),(
    'Diablos',
    'https://monsterhunterworld.wiki.fextralife.com/file/Monster-Hunter-World/mhw-diablos_render_001.png',
    387,
    'yes',
    'The apex monster of the Wildspire Waste. A menacing, territorial beast that lurks underground. Make some armor from his horns.',
    'available',
    (SELECT id FROM creature_types WHERE type='Dragon')
  ),
  (
    'Majestick',
    'https://i.imgur.com/s39N3.jpg',
    276,
    'yes',
    'Is really pretty, but so forelorn. ',
    'available',
    (SELECT id FROM creature_types WHERE type='Unicorn')
  ),
  (
    'Peter Pegasus',
    'https://vignette.wikia.nocookie.net/disney/images/e/e7/Peter_Pegasus.jpg/revision/latest?cb=20180601060225',
    2,
    'no',
    'Fell from the clouds and into your arms. Is not really a unicorn, but who cares?',
    'available',
    (SELECT id FROM creature_types WHERE type='Unicorn')
  ),
  (
    'Jimmy the Unicorn',
    'https://cdn.shopify.com/s/files/1/1365/2497/products/Rainbow-unicorn-mask_900x.png',
    28,
    'no',
    'I am really a unicorn, seriously!',
    'available',
    (SELECT id FROM creature_types WHERE type='Unicorn')
  ),
  (
    'Lisa Frank',
    'https://cdn.shopify.com/s/files/1/2362/8001/products/rainbow-unicorn-paint-with-diamonds-bfcm-fall-sale-fantasy-november-2018-round_648_600x.jpg',
    6828,
    'yes',
    'A the queen unicorn of your childhood dreams.',
    'available',
    (SELECT id FROM creature_types WHERE type='Unicorn')
  ),
  (
    'Squeee',
    'https://i.imgur.com/yWOb3il.jpg',
    8,
    'no',
    'So CUTE.',
    'available',
    (SELECT id FROM creature_types WHERE type='Unicorn')
  ),(
    'Junior Junior Junior',
    'https://i.imgur.com/I4XEvGQ.jpg',
    1,
    'yes',
    'An abandoned baby chimera, ready for you to love, love, and love.',
    'available',
    (SELECT id FROM creature_types WHERE type='Chimera')
  ),(
    'Baby Baby Baby',
    'https://i.imgur.com/Frm1U2e.png',
    1,
    'yes',
    'Another abandoned baby chimera, ready for you to love, love, and love.',
    'available',
    (SELECT id FROM creature_types WHERE type='Chimera')
  ),(
    'Jim, John, and Billybob',
    'https://i.pinimg.com/originals/34/44/3d/34443d0a305fb08fd115d2a3a0ebe7d7.jpg',
    131,
    'yes',
    'They are really actually very cuddly.',
    'available',
    (SELECT id FROM creature_types WHERE type='Chimera')
  ),(
    'Karen',
    'https://i.imgur.com/4WR1iFj.jpg',
    98,
    'no',
    'No Karen, put that down.',
    'available',
    (SELECT id FROM creature_types WHERE type='Kelpi')
  ),(
    'Josh',
    'https://i.pinimg.com/originals/34/aa/b3/34aab386be816ce2332f38262ce2ea97.jpg',
    72,
    'no',
    'Josh can be emo at times.',
    'available',
    (SELECT id FROM creature_types WHERE type='Kelpi')
  ),(
    'Allen',
    'https://i.pinimg.com/originals/85/e8/75/85e875643f9e7dd70c15917743659594.jpg',
    124,
    'yes',
    'Jesus f-ing christ, Allen is horrifying.',
    'available',
    (SELECT id FROM creature_types WHERE type='Kelpi')
  ),(
    'Cynthia',
    'https://i.imgur.com/45JFl1p.jpg',
    152,
    'yes',
    'Cynthia leaves puddles everywhere. Kelpies, amiright?',
    'available',
    (SELECT id FROM creature_types WHERE type='Kelpi')
  ),(
    'Adam',
    'https://i.imgur.com/8XwZTr2g.jpg',
    82,
    'yes',
    'Adam is kind of a badass.',
    'available',
    (SELECT id FROM creature_types WHERE type='Kelpi')
  ),(
    'Lord Killigan',
    'https://i.imgur.com/5jY0SGU.jpg',
    8987,
    'yes',
    'I am the king of the sun.',
    'available',
    (SELECT id FROM creature_types WHERE type='Phoenix')
  ),(
    'Aoife the Elegant',
    'https://i.imgur.com/E0p7yjU.jpg',
    6568,
    'yes',
    'I am the prettiest girl at the ball.',
    'available',
    (SELECT id FROM creature_types WHERE type='Phoenix')
  ),(
    'Cootie and Patootie',
    'https://i.pinimg.com/originals/df/41/2d/df412d59c953be9cd3b13f8a069104a4.jpg',
    9568,
    'yes',
    'Twin baby phoenixes. Or are they?',
    'available',
    (SELECT id FROM creature_types WHERE type='Phoenix')
  ),(
    'Lady Ephemeral',
    'https://i.pinimg.com/originals/ae/e4/ee/aee4eeb7ff35da99e7237599545d3e9a.jpg',
    588,
    'yes',
    'A little too dramatic.',
    'available',
    (SELECT id FROM creature_types WHERE type='Phoenix')
  ),(
    'Joey Tryagain',
    'https://i.pinimg.com/originals/6a/ce/fb/6acefbc85beebad8b259538394ba9cf2.jpg',
    3580,
    'yes',
    'Keep trying until you succeed!',
    'available',
    (SELECT id FROM creature_types WHERE type='Phoenix')
  );
INSERT INTO adoption_applications(
    name,
    phone_number,
    email,
    home_status,
    application_status,
    creature_id
  )
VALUES
  (
    'A BAD OWNER',
    '617-666-6666',
    'animal@abuser.com',
    'own',
    'pending',
    2
  ),
  (
    'Princess Peach',
    '617-666-8901',
    'princess@peach.com',
    'rent',
    'pending',
    6
  ),
  (
    'Finn',
    '617-666-8888',
    'baby@nephew.com',
    'own',
    'pending',
    3
  );