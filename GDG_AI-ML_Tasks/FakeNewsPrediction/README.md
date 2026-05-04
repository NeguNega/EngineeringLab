# 🧠 Fake News Detection using Neural Network

## 📌 Project Overview
This project builds a Neural Network model to classify news headlines as **Fake** or **Real**.  
The model learns patterns from text data using Natural Language Processing (NLP) techniques and predicts whether a given headline is trustworthy.

---

## 🎯 Objective
- Input: News headline (text)
- Output:
  - 0 → Real News
  - 1 → Fake News

---

## 🧩 Project Steps

### 1. Data Loading & Exploration
- Loaded dataset using Pandas
- Checked dataset structure and class distribution

### 2. Text Preprocessing
- Converted text into numerical form using:
  - TF-IDF Vectorization
- Cleaned and prepared text data

### 3. Data Splitting
- Training set: 80%
- Testing set: 20%

### 4. Model Building
- Built a Feedforward Neural Network with:
  - Input Layer
  - Hidden Layer (128 neurons)
  - Hidden Layer (64 neurons)
  - Output Layer (1 neuron)

### 5. Training
- Loss Function: Binary Crossentropy

### 6. Evaluation
- Measured model performance using:
  - Accuracy
  - Loss

### 7. Testing
- Tested model on new custom headlines

---

## ⚙️ Technologies Used
- Python
- Pandas
- NumPy
- Scikit-learn
- TensorFlow / Keras

---


## 🔗 Project Links
- Google Colab Notebook:  
  https://colab.research.google.com/drive/1VbN27fAKUAf1_Nq-w2AX_WVq_ERP0tmb?usp=sharing

---

## 💡 Example Predictions

| Headline | Prediction |
|--------|-----------|
| Scientists confirm water on Mars | Real |
| Aliens have landed in New York | Fake |

---

## 🚀 Future Improvements
- Try more hidden layers
- Experiment with different neurons
- Compare with other ML models (SVM, Logistic Regression)
- Use advanced models like LSTM or BERT

---

## 👤 Author
- Negasi
