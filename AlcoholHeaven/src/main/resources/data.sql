-- FRIEND 테이블에 데이터 삽입
INSERT INTO `friend` (`userId`, `title`, `intro`, `region`, `kindOf`, `img`, `orgImg`, `heart`)
VALUES
('alice', '와인 애호가 모임', '와인을 좋아하고 다양한 와인을 시음하며 이야기 나눌 친구를 찾습니다.', '서울', '와인', '예시1.jpg', 'alice_wine_org.jpg', 10),
('bob', '맥주와 함께하는 시간', '맥주를 좋아하며 다양한 종류의 맥주를 함께 즐길 수 있는 친구를 찾고 있습니다.', '부산', '맥주', '예시2.jpg', 'bob_beer_org.jpg', 8),
('charlie', '전통주 사랑 모임', '한국 전통주를 좋아하며 함께 시음하고 이야기 나눌 친구를 찾습니다.', '대구', '전통주', '예시3.jpg', 'charlie_soju_org.jpg', 12),
('david', '칵테일 만들기 취미', '집에서 다양한 칵테일을 만들어보는 것을 좋아합니다. 함께 만들고 즐길 친구를 찾고 있어요.', '인천', '칵테일', '예시4.jpg', 'david_cocktail_org.jpg', 6),
('emma', '소주와 어울리는 안주 만들기', '소주를 좋아하고 소주에 어울리는 다양한 안주를 만들어보는 것을 좋아합니다.', '광주', '소주', '예시5.jpg', 'emma_soju_org.jpg', 7),
('frank', '막걸리와 함께하는 전통 음식', '막걸리와 함께 한국 전통 음식을 즐기는 것을 좋아합니다.', '대전', '막걸리', '예시6.jpg', 'frank_makgeolli_org.jpg', 9),
('grace', '와인과 어울리는 치즈', '와인과 함께 다양한 치즈를 시도해보는 것을 좋아합니다.', '울산', '와인', '예시7.jpg', 'grace_wine_cheese_org.jpg', 5),
('henry', '맥주와 치킨 모임', '맥주와 치킨을 좋아하며 함께 즐길 친구를 찾습니다.', '수원', '맥주', '예시8.jpg', 'henry_beer_chicken_org.jpg', 11),
('irene', '막걸리와 파전', '막걸리와 파전을 좋아하며 함께 즐길 친구를 찾습니다.', '대구', '막걸리', '예시9.jpg', 'irene_makgeolli_org.jpg', 4),
('jack', '위스키와 함께하는 시간', '위스키를 좋아하며 다양한 위스키를 함께 즐길 친구를 찾고 있습니다.', '서울', '위스키', '예시10.jpg', 'jack_whisky_org.jpg', 13),
('kate', '칵테일 시음 모임', '다양한 칵테일을 시음하며 이야기를 나눌 친구를 찾습니다.', '부산', '칵테일', '예시11.jpg', 'kate_cocktail_org.jpg', 3),
('leo', '맥주와 피자', '맥주와 피자를 함께 즐길 친구를 찾습니다.', '대전', '맥주', '예시12.jpg', 'leo_beer_pizza_org.jpg', 8),
('mia', '와인과 디저트', '와인과 함께 다양한 디저트를 즐기는 것을 좋아합니다.', '인천', '와인', '예시13.jpg', 'mia_wine_dessert_org.jpg', 7),
('nick', '소주와 삼겹살', '소주와 삼겹살을 좋아하며 함께 즐길 친구를 찾습니다.', '광주', '소주', '예시14.jpg', 'nick_soju_org.jpg', 10),
('olivia', '칵테일 파티', '다양한 칵테일을 만들어보고 함께 즐길 친구를 찾습니다.', '수원', '칵테일', '예시15.jpg', 'olivia_cocktail_org.jpg', 6),
('peter', '맥주와 감자튀김', '맥주와 감자튀김을 함께 즐길 친구를 찾습니다.', '울산', '맥주', '예시16.jpg', 'peter_beer_fries_org.jpg', 9),
('quincy', '막걸리와 김치전', '막걸리와 김치전을 좋아하며 함께 즐길 친구를 찾습니다.', '대구', '막걸리', '예시17.jpg', 'quincy_makgeolli_org.jpg', 5),
('rachel', '와인과 해산물', '와인과 함께 해산물을 즐기는 것을 좋아합니다.', '서울', '와인', '예시18.jpg', 'rachel_wine_seafood_org.jpg', 11),
('sam', '소주와 고기구이', '소주와 고기구이를 좋아하며 함께 즐길 친구를 찾습니다.', '부산', '소주', '예시19.jpg', 'sam_soju_org.jpg', 4),
('tina', '칵테일과 스낵', '칵테일과 함께 다양한 스낵을 즐기는 것을 좋아합니다.', '대전', '칵테일', '예시20.jpg', 'tina_cocktail_snacks_org.jpg', 7);

INSERT INTO alcohol (userId, name, detailRegion, kindOf, content, region, weight, img)
VALUES 
("admin","삼해소주", "서울특별시","증류식소주", "식품명인 제69호였던 고 김택상 명인에 의해 빚어졌다.\n조선시대 중엽부터 삼해주를 증류하여 만들기 시작한 고급소주다.\n쌀 소모가 많은 삼해주를 증류시켜 원래 양의 30%밖에 얻지 못해 상당한 사치품이었다고 한다.", "서울",45,'삼해소주_서울_증류식소주.jpg'),
("admin","송절주", "서울특별시", "약주", "서울무형문화재 제2호로 지정되어 있으며 전승자는 이성자 명인이다.\n16세기 정도부터 시작된 것으로 추정되고 있으며 서울 부근의 중산층과 양반가에서 약용으로 빚어진 술이다.", "서울",16,'송절주_서울_약주.jpg'),
("admin","향온주", "서울특별시", "증류식소주", "서울무형문화재 제9호이며 전승자는 박현숙 명인이다.\n녹두누룩으로 빚는게 특징으로 본래 왕이 마시던 어주였다.\n이후 인현왕후를 통해 하동정씨 집안에 전해져 가양주가 되었다.", "서울", 40,'향온주_서울_증류식소주.jpg'),
("admin","부의주", "화성시", "약주", "경기무형문화재 2호로 지정된 적이 있으며 전승자는 권기훈 명인이다.\n고려시대때부터 빚었으며 맑은 술에 밥알이 동동 떠 있는 모습이 마치 개미가 물에 떠 있는 것과 같다 하여\n부의주(浮蟻酒)란 이름이 붙었다.", "경기도", 10,'부의주_경기도_약주.png'),
("admin","옥로주", "안산시", "증류식소주", "본래는 남원 지역의 술로 남원에서 군포로, 다시 용인으로 양조장을 옮기다 우여곡절 끝에\n안산시 대부도에서 생산중.", "경기도", 45,'옥로주_경기도_증류식소주.jpg'),
("admin","남한산성소주", "광주시", "증류식소주", "경기무형문화재 13호로 전승자는 강환구 명인.\n재래식 조청을 사용하는게 특징으로 남한산성을 축조한 조선 선조 때부터 빚어왔으며\n나중엔 임금에게도 진상되었다." , "경기도", 40,'남한산성소주_경기도_증류식소주.jpg'),
("admin","한주", "안성시", "증류식소주", "송절주 기능 보유자인 이성자 명인이 제조하며 원래 이름은 '백로주'였다.\n조선시대에 사용하던 500년 역사의 증류방식 '로주두말빚이' 비법으로 빚는다." , "경기도", 25,'한주_경기도_증류식소주.jpg'),
("admin","약산춘", "서울특별시", "약주", "서울 약현에 살던 선비인 서성의 집에서 빚던 술이라 전해진다.\n예전부터 서울의 토속주로 유명했고 지금도 대구 서씨 집안에선 약산춘을 빚는 문화를 자랑스럽게 이어간다고 한다." , "서울", 18,'약산춘_서울_약주.jpg'),
("admin","주교주", "고양시", "약주", "배다리 술도가를 5대째 이어온 밀양 박씨 집안에서 100년넘게 전해진 가양주다.\n양조장이 처음 자리잡은 주교동에서 이름을 따왔다고 한다.\n월계수잎을 띄워 먹는게 특징이다." , "경기도", 16,'주교주_경기도_약주.jpg'),
("admin","특주", "김포시", "약주", "조선시대 말부터 이어져왔으며 본래 음력으로 첫달부터 100일동안 빚는 백일주의 한 종류다.\n품질이 뛰어난 김포쌀로 만들어 그 맛과 명성이 예전부터 높았다고 한다." , "경기도", 15,'특주_경기도_약주.jpg'),
("admin","칠선주", "인천광역시", "약주", "조선 정조때인 1777년에 궁중에 진상된 것이 최초의 기록이다.\n일곱가지 약재를 넣고 만들며 자주 마시면 신선처럼 오래산다는 이야기가 있어 칠선주라는 이름이 붙었다." , "경기도", 16,'칠선주_경기도_약주.jpg'),
("admin","옥미주", "안양시", "약주", "본래는 단양과 제천 지방에서 내려오던 남평 문씨 가문의 가양주였다.\n옥수수와 현미를 넣어 빚어 이름처럼 구슬처럼 아름다운 담황색이 나며 부드러운 감칠맛이 특징이다." , "경기도", 11,'옥미주_경기도_약주.jpg'),
("admin","불술", "삼척군", "약주", "쌀과 엿기름, 누룩을 이용해 만든다.\n짚불(짚을 태운 열)을 이용해 만들어 불술이라고 한다.\n도수가 다소 높고, 술 빛깔이 진황빛을 띠며 상당히 달콤한 편이다." , "강원도", 18,'불술_강원도_약주.jpg'),
("admin","율무주", "횡성군", "약주", "의이인주라고도 하며 의이인은 한국어로 율무를 뜻한다.\n율무와 멥쌀을 함께 섞어 빚은 술로 특이하게도 와인맛이 난다." , "강원도", 14,'율무주_강원도_약주.jpg'),
("admin","감자술", "평창군", "약주", "조선후기부터 화전민들에 의해 제조되기 시작한 술이다.\n삶은 감자와 쌀을 넣어 만든 전통주로, 감자 ‘서(薯)’를 써서 ‘서주’라고도 부른다." , "강원도", 13,'감자술_강원도_약주.jpg'),
("admin","경주교동법주", "경주시", "기타주류", "경주 최씨 집안의 유명한 가양주로 300년 넘게 대대로 이어서 빚어오고 있다.\n국가무형문화재 제86-3호다.", "경상도", 18,'경주교동법주_경상도_기타주류.jpg'),
("admin","산성막걸리", "부산광역시", "탁주", "대한민국 식품명인 제49호인 유청길 명인이 빚는다.\n1909년도 경 이곳 화전민이 생계수단으로 누룩을 빚기 시작한데서 유래했다." , "경상도", 8,'산성막걸리_경상도_탁주.jpg'),
("admin","안동소주", "안동시", "증류식소주", "전통 증류식 소주의 대명사격인 술.\n식품명인 제6호 박재서 명인과 식품명인 제20-가호인 김연박 명인이 제조한다.\n경북무형문화재 제12호로 지정되어 있다." , "경상도", 45,'안동소주_경상도_증류식소주.jpg'),
("admin","고가송주", "합천군", "약주", "합천지역 은진 송씨 문중의 가양주다.\n고택에서 찹쌀, 솔잎, 누룩, 엿기름으로 만드는 송주(松酒)이기 때문에 고가송주라고 부른다." , "경상도", 11,'고가송주_경상도_약주.jpg'),
("admin","선주", "봉화군", "향주", "봉화 명호면 김의동 가(家)에서 조선시대부터 전승되어 온 가양주로 오가피를 넣어 만든다.\n오래마시면 신선이 된다고 하여 선주라고 부르며,\n도수는 40도에 달하지만 숙취는 적다고 한다." , "경상도", 40,'선주_경상도_향주.jpg'),
("admin","황금주", "경주시", "약주", "신라시대부터 이어져온 유서깊은 술이다.\n술의 색이 마치 황금같아 황금주라 부르며 은은한 국화향이 부드러운 뒷맛이 특징이라고 한다." , "경상도", 13,'황금주_경상도_약주.jpg'),
("admin","유자주", "남해군", "약주", "조선시대부터 유자가 많이 나던 남해에서 즐겨마시던 술이었으나 일제시대 이후 명맥이 끊겼었다가\n지역 주민들의 도움 덕분에 복원에 성공했다.\n아름다운 유자빛과 상큼한 유자향이 나는 술이다." , "경상도", 12,'유자주_경상도_약주.jpg'),
("admin","선산약주", "구미시", "약주", "조선초의 저명한 성리학자인 김종직이 개발했으며 금오서원에서 제자들과 함께 즐겨마셨다고 한다.\n은은한 솔향과 낮은 도수로 인한 부드러움이 특징이다." , "경상도", 12,'선산약주_경상도_약주.jpg'),
("admin","송화백일주", "완주군", "향주", "전라북도 무형문화재 제6-4호, 대한민국식품명인 제1호인 벽암 스님이 빚는 술.\n진과 비슷한 맛과 향이 특징", "전라도", 38, "송화백일주_향주_전라도.jpg"),
("admin","진양주", "해남군", "약주", "전라남도 무형문화재 제25호로 지정되어 있다.\n광산 김씨 가문의 가양주다.\n집안에 시집온 궁인 출신 며느리가 전수했다는 술." , "전라도", 16, "진양주_약주_전라도.jpg"),
("admin","모주", "전주시", "탁주", "전주 전통 한정식과 콩나물국밥집에 가면 흔히 보이는 전주지역의 전통주." , "전라도", 1.5, "모주_탁주_전라도.jpg"),
("admin","백화주", "김제시", "청주", "학성강당이라는 개인 서당을 유지하던 지역 유지 가문이 만들어 먹던 가양주.\n100가지 말린 꽃으로 만들었다 해서 백화주다." , "전라도", 15,"백화주_청주_전라도.jpg"),
("admin","송죽오곡주", "전주시", "약주", "모악산 수왕사에서 진묵대사 때부터 만들어오던 유서깊은 약용주이다.\n송화백일주를 만드는 벽암스님이 오곡과 함께 산에서 나는 각종 약재와 약수를 이용하여 빚는다." , "전라도", 16,"송죽오곡주_약주_전라도.jpg"),
("admin","고소리술", "서귀포시", "증류식소주",  "제주특별자치도 무형문화재 제11호. 보유자는 대한민국식품명인 제84호 김희숙 선생.\n특징으로는 과자처럼 달큰한 곡물향과 약간의 탄내, 도수에 비해 알코올감이 매우 적다는 것." , "제주도", 40,"고소리술_증류식소주_제주도.jpg"),
("admin","오메기술", "서귀포시", "약주", "이름대로 제주의 대표 음식 중 하나인 오메기떡을 이용해 빚은 술.\n제주특별자치도 무형문화재 제3호. 보유자는 대한민국식품명인 제68호 강경순 선생." , "제주도", 13, "오메기술_약주_제주도.jpg"),
("admin","허벅술", "서귀포시", "청주", "제주도에서 유일하게 논농사가 가능하던 오조리 마을에서 마을 축제에 사용하기 위해 쌀로 빚은 술.\n제주도에서 물을 길을 때 사용하던 항아리인 허벅에 넣고 후숙시킨다고 해서 허벅술이다." , "제주도", 35, "허벅술_청주_제주도.jpg"),
("admin","계룡백일주", "공주시", "약주", "충청남도 무형문화재 제7호, 전승자는 대한민국식품명인 제4-가호 이성우 선생.\n본래 왕실에서만 빚어지던 궁중술이었으나 인조가 당시 일등공신이였던 연평부원군 이귀에게 술의 제조기법을 하사해서 그 가문이 대대로 주조하였다고 한다." , "충청도", 30, "계룡백일주_약주_충청도.jpg"),
("admin","구기자주", "청양군", "약주", "'청양 둔송 구기주'라는 명칭으로 판매한다.\n하동정씨 집안의 가양주로 구기자의 열매, 잎, 뿌리가 모두 들어간다.\n충청남도 무형문화재 제30호, 전승자는 대한민국식품명인 제11호 임영순 선생." , "충청도", 16, "구기자주_약주_충청도.jpg"),
("admin","금산인삼주", "금산군", "기타주류", "충청남도 무형문화재 제19호, 전승자는 대한민국식품명인 제2호 김창수 선생.\n1399년 도승지와 이조판서를 지낸 김문기 가문에서 전해내려오는 술로 담금주가 아니라\n주조과정 중 인삼을 갈아넣어 술 원료와 같이 발효시키는게 특징이다." , "충청도", 23,"금산인삼주_기타주류_충청도.jpg"),
("admin","송로주", "보은군", "증류주", "충청북도 무형문화재 제3호. 기록상 16세기 조선시대부터 주조되어온 술이며 이후 평산신씨 집안의 가양주가 되었다.\n현재는 전수 보조자였던 임경순 명인이 대를 이어 제조중이다." , "충청도", 48,"송로주_증류주_충청도.jpg"),
("admin","청명주", "충주시", "약주", "충청북도 무형문화재 제2호. 충주 창동지역에서 대대로 살던 김해 김씨 가문의 가양주로\n문중 문헌인 '향전록'에 기록된 제조비법으로 만들어진다.\n일년 24절기 중 청명일에 사용하기 위해 담그기 때문에 청명주라고 한다." , "충청도", 18, "청명주_약주_충청도.jpg"),
("admin","한산소곡주", "서천군", "기타주류", "한산 지역의 유명한 전통주이며 흔히 '앉은뱅이 술'이라는 별명을 가지고 있다.\n오주연문장전산고에서 꼽은 조선 명주 네가지 중 하나다.\n충청남도 무형문화재 3호. 쌀로만 빚어낸 진하고 달콤한 맛이 특징이며,\n양조장에 따라 다양한 재료를 첨가하여 특색이 있다." , "충청도", 16,"한산소곡주_기타주류_충청도.jpg"),
("admin","국화주", "대전광역시", "약주", "대전무형문화재 제9-2호로 전승자는 윤자덕 명인.\n노란 국화꽃을 사용해 황화주라고도 부르며 송순주와 같이 송촌동 은진 송씨 가문의 가양주다." , "충청도", 32, "국화주_약주_충청도.jpg"),
("admin","대덕주", "대전광역시", "약주", "신탄진에 있던 진주유씨 종가의 제사주이다.\n원래 이름없는 가양주였으나 상품화를 하면서 대덕주라는 이름이 붙여졌다.\n단맛이 꽤 강함에도 깔끔한 목넘김이 특징이다." , "충청도", 16, "대덕주_약주_충청도.jpg"),
("admin","들국화주", "서산시", "약주", "본래 야생 들국화에 여러 한약재를 넣어 빚은 술로 지역 주민들이 즐겨마시던 향토주였으며 근래에 상품화되었다.\n도수는 13도이며 들국화향이 깊고 맛이 부드럽다고 한다." , "충청도", 14,"들국화주_약주_충청도.jpg"),
("admin","한라산", "제주", "소주","보드카 대신 즐길 수 있는 소주로 유형해 젊은 층이 즐겨 찾고 있다.\n'한라토닉 세트'를 파는 가게가 많아졌다.\n낮은 도수의 부드러운 소주를 찾는 트렌드에 맞춰 17도의 한라산'17'출시", "제주도", 17, "한라산_소주_제주도.jpg"),
("admin","좋은 데이", "부산", "소주", "16.9도의 낮은 도수로 마니아층이 두터우며\n토종 부산 기업인 대선주조에서 생산되는 제품이다.\n부산이나 경남 여행 시, 인증샷에서 빼놓을 수 없는 친구들이다.","경상도", 16.9, "좋은데이_소주_경상도.jpg"),
("admin","잎새주","전남","소주","일반 소주보다 쓴맛이 조금 더 강하지만 목에서 전해오는 역한 맛이 거의 없다.\n17.8도의 도수를 자랑하고 전라도의 식도락 여행에서 빠질 수 없다.","전라도", 17.3, "잎새주_소주_전라도.jpg"),
("admin","참소주","대구","소주","경북권에서 핵인싸템 '참소주', 오리지널은 17도 이며 새로 나온 '맛있는 참'은 16.7도이다.\n희석식 소주라 화학약품 냄새가 적다","경상도", 16.5, "참소주_소주_경상도.jpg"),
("admin","처음처럼","강원","소주","롯데 주류에서 생산하는 강원도의 대표 소주.\n16.9도 높지 않은 도수와 부드러움에 타깃층이 두텁다.","강원도",16.5, "처음처럼_소주_강원도.jpg"),
("admin","하이트", "전북","소주","참이슬과 마찬가지로 하이트진로에서 만들지만 흔히 볼 수 없는 소주.\n전북의 깨끗함과 청량함을 가진 대표 소주","전라도", 15.5, "하이트_소주_전라도.jpg"),
("admin","이제 우린","대전","소주","맥키스 컴퍼니에서 출시한 소주.\n대전과 충남지역에서만 볼 수 있는 희귀템이며\n17도로 강하고 깔끔한 맛에 다들 찾는다.","충청도", 16.5, "이제우린_소주_충청도.jpg"),
("admin","참이슬","서울특별시","소주","주류계의 대가.\n전 세계 소주 판매량 1위이며 서울을 포함한 수도권과 호남지역에서 인지도 끝판왕","서울", 16, "참이슬_소주_서울.jpg");


-- FOOD 테이블에 데이터 삽입
INSERT INTO `FOOD` (`userId`, `menu`, `content`, `title`, `region`, `kindOf`, `heart`, `img`, `orgImg`)
VALUES
('alice', '치즈 플래터', '와인과 어울리는 다양한 치즈를 소개합니다.', '치즈', '옥동', '와인', 15, '치즈.jpg', 'wine_cheese_org.jpg'),
('bob', '감자튀김', '맥주와 찰떡궁합인 바삭한 감자튀김 레시피입니다.', '감자튀김', '목동', '맥주', 12, '감자튀김.jpg', 'beer_fries_org.jpg'),
('charlie', '오징어볶음', '매콤한 오징어볶음과 소주의 환상적인 조합입니다.', '오징어볶음', '인계동', '소주', 18, '오징어볶음.jpg', 'soju_squid_org.jpg'),
('david', '파전', '전통적인 막걸리와 파전의 조합을 소개합니다.', '파전', '송파', '막걸리', 20, '파전.jpg', 'makgeolli_pajeon_org.jpg'),
('emma', '나초', '다양한 칵테일과 함께 즐기는 나초 레시피입니다.', '나초', '부천', '칵테일', 9, '나초.jpg', 'cocktail_nachos_org.jpg'),
('frank', '초콜릿', '와인과 함께 즐기는 다양한 초콜릿을 소개합니다.', '초콜릿', '세종', '와인', 13, '초콜릿.jpg', 'wine_chocolate_org.jpg'),
('grace', '치킨', '맥주와 함께 즐기는 바삭한 치킨 레시피입니다.', '치킨', '역삼', '맥주', 17, '치킨.jpg', 'beer_chicken_org.jpg'),
('henry', '삼겹살', '소주와 찰떡궁합인 삼겹살 요리법을 소개합니다.', '삼겹살', '강남', '소주', 14, '삼겹살.jpg', 'soju_porkbelly_org.jpg'),
('irene', '김치전', '막걸리와 함께 즐기는 김치전 레시피입니다.', '김치전', '노원', '막걸리', 16, '김치전.jpg', 'makgeolli_kimchijeon_org.jpg'),
('jack', '스테이크', '위스키와 어울리는 스테이크 요리법을 소개합니다.', '스테이크', '길음', '위스키', 11, '스테이크.jpg', 'whisky_steak_org.jpg'),
('kate', '핑거푸드', '다양한 칵테일과 어울리는 핑거푸드 레시피입니다.', '핑거푸드', '수유리', '칵테일', 19, '핑거푸드.jpg', 'cocktail_fingerfoods_org.jpg'),
('leo', '피자', '맥주와 함께 즐기는 피자 레시피입니다.', '피자', '대전', '맥주', 18, '피자.jpg', 'beer_pizza_org.jpg'),
('mia', '해산물', '와인과 어울리는 다양한 해산물 요리를 소개합니다.', '해산물', '인천', '와인', 15, '해산물.jpg', 'wine_seafood_org.jpg'),
('nick', '닭발', '소주와 함께 즐기는 매콤한 닭발 레시피입니다.', '닭발', '경기도 광주', '소주', 13, '닭발.jpg', 'soju_chickenfeet_org.jpg'),
('olivia', '과일', '다양한 칵테일과 함께 즐기는 신선한 과일을 소개합니다.', '과일', '수원', '칵테일', 10, '과일.jpg', 'cocktail_fruits_org.jpg'),
('peter', '소시지', '맥주와 찰떡궁합인 소시지 요리법을 소개합니다.', '소시지', '동탄', '맥주', 17, '소시지.jpg', 'beer_sausage_org.jpg'),
('quincy', '부추전', '막걸리와 함께 즐기는 부추전 레시피입니다.', '부추전', '대구 동성로', '막걸리', 16, '부추전.jpg', 'makgeolli_buchujeon_org.jpg'),
('rachel', '생선', '와인과 어울리는 다양한 생선 요리를 소개합니다.', '생선', '서래포구', '와인', 12, '생선.jpg', 'wine_fish_org.jpg'),
('sam', '두부김치', '소주와 함께 즐기는 두부김치 레시피입니다.', '두부김치', '부산', '소주', 14, '두부김치.jpg', 'soju_tofukimchi_org.jpg'),
('tina', '케이크', '다양한 칵테일과 어울리는 케이크를 소개합니다.', '케이크', '대전', '칵테일', 11, '케이크.jpg', 'cocktail_cake_org.jpg');

-- NOTICE 테이블에 데이터 삽입
INSERT INTO `notice` (`userId`, `content`, `title`, `password`)
VALUES
('admin', '알코올헤븐에 오신 것을 환영합니다!', '환영 인사', 1234),
('manager', '새로운 이벤트를 확인해보세요.', '이벤트 공지', 1234),
('staff', '사이트 유지보수 예정입니다.', '유지보수 공지', 1234),
('admin', '사용자 여러분의 의견을 기다립니다.', '의견 요청', 1234),
('manager', '새로운 메뉴가 추가되었습니다.', '메뉴 추가', 1234),
('staff', '점검이 완료되었습니다.', '점검 완료', 1234),
('admin', '알코올헤븐 이용 가이드', '이용 가이드', 1234),
('manager', '곧 다가올 프로모션을 놓치지 마세요!', '프로모션 안내', 1234),
('staff', '서버 업그레이드 예정입니다.', '서버 업그레이드', 1234),
('admin', '이벤트 참여 방법을 안내합니다.', '이벤트 참여 안내', 1234),
('manager', '새로운 기능이 추가되었습니다.', '기능 추가', 1234),
('staff', '긴급 점검이 있었습니다.', '긴급 점검', 1234),
('admin', '안전한 이용을 위한 주의사항', '주의사항 안내', 1234),
('manager', '여러분의 피드백을 기다립니다.', '피드백 요청', 1234),
('staff', '알코올헤븐 업데이트 예정입니다.', '업데이트 공지', 1234),
('admin', '신규 가입 이벤트 안내', '신규 가입 이벤트', 1234),
('manager', '이용 약관이 변경되었습니다.', '이용 약관 변경', 1234),
('staff', '정기 점검 안내', '정기 점검', 1234),
('admin', '커뮤니티 가이드라인을 확인하세요.', '가이드라인 안내', 1234),
('manager', '고객센터 운영시간 변경 안내', '운영시간 변경', 1234);

-- REVIEW 테이블에 데이터 삽입
-- 1 알콜
-- 2 푸드
-- 3 프렌드
INSERT INTO `REVIEW` (`id`, `writer`, `content`, `type`)
VALUES
(1, 'user1', '정말 맛있고 분위기도 좋았어요!', 2),
(2, 'user2', '서비스가 아쉬웠습니다.', 2),
(3, 'user3', '또 가고 싶은 곳입니다.', 3),
(4, 'user4', '기대 이하였어요.', 1),
(5, 'user5', '친절하고 맛있었습니다.', 2),
(6, 'user6', '재방문 의사 없습니다.', 1),
(7, 'user7', '추천합니다!', 3),
(8, 'user8', '가격 대비 별로였습니다.', 1),
(9, 'user9', '최고의 경험이었어요.', 1),
(10, 'user10', '보통이었어요.', 2),
(11, 'user11', '정말 훌륭했어요!', 1),
(12, 'user12', '다시 가고 싶지 않아요.', 2),
(13, 'user13', '매우 만족했습니다.', 3),
(14, 'user14', '별로였어요.', 3),
(15, 'user15', '좋은 추억 만들었어요.', 1),
(16, 'user16', '실망했어요.', 2),
(17, 'user17', '기대 이상이었어요!', 1),
(18, 'user18', '돈이 아깝습니다.', 2),
(19, 'user19', '완벽했어요!', 3),
(20, 'user20', '더 나은 곳이 많아요.', 2);
