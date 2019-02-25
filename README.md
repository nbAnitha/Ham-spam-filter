# Ham-spam-filter



The application for filtering spam messages using bigram model with python language and java .


N-grams are used for language modeling based on word prediction , it predicts next word of a sentence from previous N-1 words. Bigram is the 2-word sequence of N-grams which predicts the next word of a sentence using the previous one word. Instead of considering the whole history of a sentence or a particular word sequence, a model like bigram can be occupied in terms of an approximation of history by occupying a limited history.

Identification of a message as ‘ham’ or ‘spam’ is a classification task since the target variable has got discrete values that is ‘ham’ or ‘spam’

1.Inspecting and Separating messages given into ‘ham’ and ‘spam’ categories

2. Preprocessing text
  .Removal of Punctuation Marks
  .Converting to Lowercase
  .Tokenizing
  .Lemmatizing Words
  
3.Feature extraction

4.Stop words removing

5.Get frequency distribution of features

6.Building a model for prediction

7.Smoothing
