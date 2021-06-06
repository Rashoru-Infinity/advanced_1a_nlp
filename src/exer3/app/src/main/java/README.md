# Evil-Fortune-Teller
あなたの運勢を占いましょう。 
![FortuneTelling](https://user-images.githubusercontent.com/49583698/120918725-d735a580-c6f0-11eb-831a-7861a81b846a.gif)

# Build
[こちらのディレクトリ](https://github.com/Rashoru-Infinity/advanced_1a_nlp/tree/master/src/exer3)に移動してビルドをします。  
```
gradle build
```
![Build](https://user-images.githubusercontent.com/49583698/120918682-9342a080-c6f0-11eb-9755-f971440a0888.gif)

# Let's Fortune Telling
ビルドを行った後、占いを始める前に仕込みを行います。  
```
gradle  setData
```
![SetData](https://user-images.githubusercontent.com/49583698/120918704-ba00d700-c6f0-11eb-96a9-76eb214ca110.gif)
仕込みが終わったらいよいよ占いを始めます。
```
gradle run
```
占い結果に満足したら「さようなら」を告げて占いを終了します。  
![FortuneTelling](https://user-images.githubusercontent.com/49583698/120918725-d735a580-c6f0-11eb-831a-7861a81b846a.gif)

# Other Options
ビルドしたファイルの削除
```
gradle clean
```
![Clean](https://user-images.githubusercontent.com/49583698/120918761-03e9bd00-c6f1-11eb-81d2-06654b2914e3.gif)
仕込みの後片付け
```
gradle delData
```
![DelData](https://user-images.githubusercontent.com/49583698/120918765-0ea45200-c6f1-11eb-8970-02ff173f4b95.gif)

# Spoilers
- 占い師は12位しか出しません。疑うメッセージを投げると、弁明します。  
- 以下のようなメッセージを投げると占いをしてくれます。 
```
現在からの相対的な日にち(「今日」、「明後日」、「おととい」、など) + 星座(過去に入力した星座を記憶するため、初回のみ必須、その後は省略可) + 「運勢」、「占い結果」など
```
例)  
- きょうの双子座の運勢
- 本日のいて座の運勢
