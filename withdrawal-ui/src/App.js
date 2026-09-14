import React, { useEffect, useState } from "react";
import axios from "axios";
import "./App.css";

function App() {
  const [portfolios, setPortfolios] = useState([]);
  const [withdrawals, setWithdrawals] = useState([]);

  const [portfolioId, setPortfolioId] = useState("");
  const [amount, setAmount] = useState("");

  const [message, setMessage] = useState("");

  useEffect(() => {
    loadPortfolios();
    loadWithdrawals();
  }, []);

  const loadPortfolios = async () => {
    try {
      const response = await axios.get(
        "http://localhost:8080/api/portfolios"
      );

      setPortfolios(response.data);
    } catch (error) {
      console.error(error);
    }
  };

  const loadWithdrawals = async () => {
    try {
      const response = await axios.get(
        "http://localhost:8080/api/withdrawals"
      );

      setWithdrawals(response.data);
    } catch (error) {
      console.error(error);
    }
  };

  const createWithdrawal = async () => {
    try {
      await axios.post(
        "http://localhost:8080/api/withdrawals",
        {
          portfolioId: Number(portfolioId),
          amount: Number(amount),
        }
      );

      setMessage(
        "✅ Withdrawal Created Successfully"
      );

      setPortfolioId("");
      setAmount("");

      loadPortfolios();
      loadWithdrawals();

    } catch (error) {

      setMessage(
        error.response?.data ||
        "❌ Error Creating Withdrawal"
      );
    }
  };

  const totalBalance = portfolios.reduce(
    (sum, portfolio) =>
      sum + portfolio.balance,
    0
  );

  const downloadCsv = () => {
    window.open(
      "http://localhost:8080/api/withdrawals/export",
      "_blank"
    );
  };

  return (
    <div className="container">

      <div className="header">
        <h1>Investment Withdrawal System</h1>
        <p>
          Investor Portfolio Management Dashboard
        </p>
      </div>

      <div className="stats">

        <div className="stat-card">
          <h3>Portfolios</h3>
          <span>{portfolios.length}</span>
        </div>

        <div className="stat-card">
          <h3>Withdrawals</h3>
          <span>{withdrawals.length}</span>
        </div>

        <div className="stat-card">
          <h3>Total Balance</h3>
          <span>R {totalBalance}</span>
        </div>

      </div>

      <div className="section">

        <h2>Investor Details</h2>

        <p>
          <strong>Name:</strong> Mbuyelo Nyathi
        </p>

        <p>
          <strong>Age:</strong> 68
        </p>

      </div>

      <div className="section">

        <h2>Portfolio Dashboard</h2>

        <div className="portfolio-grid">

          {portfolios.map((portfolio) => (

            <div
              key={portfolio.id}
              className="portfolio-card"
            >

              <h3>
                {portfolio.productName}
              </h3>

              <p>
                <strong>Balance:</strong>
                {" "}
                R {portfolio.balance}
              </p>

              <p>
                <strong>Portfolio ID:</strong>
                {" "}
                {portfolio.id}
              </p>

            </div>

          ))}

        </div>

      </div>

      <div className="section">

        <h2>Create Withdrawal</h2>

        <select
          value={portfolioId}
          onChange={(e) =>
            setPortfolioId(e.target.value)
          }
        >

          <option value="">
            Select Portfolio
          </option>

          {portfolios.map((portfolio) => (

            <option
              key={portfolio.id}
              value={portfolio.id}
            >

              {portfolio.productName}

            </option>

          ))}

        </select>

        <input
          type="number"
          placeholder="Amount"
          value={amount}
          onChange={(e) =>
            setAmount(e.target.value)
          }
        />

        <button
          onClick={createWithdrawal}
        >
          Create Withdrawal
        </button>

        {message && (
          <p className="success">
            {message}
          </p>
        )}

      </div>

      <div className="section">

        <h2>Withdrawal History</h2>

        <table>

          <thead>
            <tr>
              <th>ID</th>
              <th>Amount</th>
              <th>Date</th>
            </tr>
          </thead>

          <tbody>

            {withdrawals.map((withdrawal) => (

              <tr key={withdrawal.id}>

                <td>
                  {withdrawal.id}
                </td>

                <td>
                  R {withdrawal.amount}
                </td>

                <td>
                  {withdrawal.withdrawalDate}
                </td>

              </tr>

            ))}

          </tbody>

        </table>

        <br />

        <button
          className="csv-btn"
          onClick={downloadCsv}
        >
          Download CSV
        </button>

      </div>

    </div>
  );
}

export default App;