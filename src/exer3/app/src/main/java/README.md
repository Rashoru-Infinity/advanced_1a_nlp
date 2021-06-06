# Evil-Fortune-Teller
あなたの運勢を占いましょう。  

# Build
[こちらのディレクトリ](https://github.com/Rashoru-Infinity/advanced_1a_nlp/tree/master/src/exer3)に移動してビルドをします。
```
gradle build
```

# Let's Fortune Telling
ビルドを行った後、占いを始める前に仕込みを行います。  
```
gradle  setData
```
仕込みが終わったらいよいよ占いを始めます。
```
gradle run
```
占い結果に満足したら「さようなら」を告げて占いを終了します。  

# Other Options
ビルドしたファイルのクリア
```
gradle clean
```
仕込みの後片付け
```
gradle delData
```
