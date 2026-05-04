
# Ride Price Estimation System

## 📌 Project Overview

This project builds a machine learning system to estimate ride prices based on trip and contextual factors such as distance, duration, traffic, weather, and demand. It demonstrates the full ML workflow: dataset design, cleaning, feature engineering, regression and classification modeling, and evaluation.

---

## 🗄 Dataset Description

* The dataset (`rides.csv`) contains **synthetic ride data** with over 150 rows.
* Features include both numerical and categorical variables.
* Continuous target variable: `ride_price`.
* Dataset was designed to reflect realistic ride scenarios while including some intentional imperfections (missing values, outliers) to simulate real-world challenges.

---

## 🛠 Features Used and Justification

| Feature       | Type        | Reason for Inclusion                          |
| ------------- | ----------- | --------------------------------------------- |
| distance_km   | Numerical   | Longer rides cost more                        |
| duration_min  | Numerical   | Time affects price, especially in traffic     |
| time_of_day   | Categorical | Rush hours can increase prices                |
| traffic_level | Categorical | Heavy traffic affects duration and price      |
| weather       | Categorical | Bad weather can increase demand/surge pricing |
| demand_level  | Categorical | High demand leads to higher prices            |
| vehicle_type  | Categorical | Premium vehicles cost more                    |

**Feature considered but excluded:** Driver experience — excluded due to difficulty simulating and lower direct impact on price.

---

## 🚀 How to Run the Notebook

1. Open `notebook/ride_price_model.ipynb` in Google Colab.
2. Upload `data/rides.csv` when prompted.
3. Run cells sequentially:

   * Data loading & inspection
   * Visualization & exploration
   * Cleaning & feature engineering
   * Regression model (predict ride prices)
   * Classification model (high-cost vs low-cost)
   * Model evaluation & reflection

---

## 📊 Key Findings

* Distance, duration, and demand were the most influential features for predicting ride prices.
* Regression model accurately predicts continuous ride prices, while classification model effectively distinguishes high-cost rides.
* Data cleaning, encoding, and scaling were critical to model performance.
* Synthetic dataset limitations: may not fully capture real-world variations; small size and missing features affect generalization.
---

## 📊Feedback and Grading of the project from my Mentor

<img width="486" height="528" alt="image" src="https://github.com/user-attachments/assets/94910b0e-fc6e-4a17-9f0b-a783a95ebd8b" />
<img width="431" height="482" alt="image" src="https://github.com/user-attachments/assets/9b98b1f2-7a97-4943-8332-3dca18584e50" />


