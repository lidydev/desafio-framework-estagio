import React, { Component } from "react";
import UserDataService from "../services/tutorial.service";

export default class UsersList extends Component {
  constructor(props) {
    super(props);
    this.onChangeSearchTitle = this.onChangeSearchTitle.bind(this);
    this.retrieveUsers = this.retrieveUsers.bind(this);
    this.refreshList = this.refreshList.bind(this);
    this.setActiveUser = this.setActiveUser.bind(this);
    this.removeAllUsers = this.removeAllUsers.bind(this);
    this.searchTitle = this.searchTitle.bind(this);

    this.state = {
      albums: [],
      currentTodo: null,
      currentIndex: -1,
      searchTitle: ""
    };
  }

  componentDidMount() {
    this.retrieveUsers();
  }

  onChangeSearchTitle(e) {
    const searchTitle = e.target.value;

    this.setState({
      searchTitle: searchTitle
    });
  }

  retrieveUsers() {
    UserDataService.getAlbums()
      .then(response => {
        this.setState({
          albums: response.data
        });
        console.log(response.data);
      })
      .catch(e => {
        console.log(e);
      });
  }

  refreshList() {
    this.retrieveUsers();
    this.setState({
      currentTodo: null,
      currentIndex: -1
    });
  }

  setActiveUser(albums, index) {
    this.setState({
      currentTodo: albums,
      currentIndex: index
    });
  }

  removeAllUsers() {
    UserDataService.deleteAll()
      .then(response => {
        console.log(response.data);
        this.refreshList();
      })
      .catch(e => {
        console.log(e);
      });
  }

  searchTitle() {
    this.setState({
      currentTodo: null,
      currentIndex: -1
    });

    UserDataService.findByTitle(this.state.searchTitle)
      .then(response => {
        this.setState({
          albums: response.data
        });
        console.log(response.data);
      })
      .catch(e => {
        console.log(e);
      });
  }

  render() {
    const { albums, currentTodo, currentIndex } = this.state;

    return (
      <div className="list row">
        <div className="col-md-8">
          <div className="input-group mb-3">
            <div className="input-group-append">
            </div>
          </div>
        </div>
        <div className="col-md-6">
          <h4>Albums List</h4>

          <ul className="list-group">
            {albums &&
              albums.map((albums, index) => (
                <li
                  className={
                    "list-group-item " +
                    (index === currentIndex ? "active" : "")
                  }
                  onClick={() => this.setActiveUser(albums, index)}
                  key={index}
                >
                  {albums.title}
                </li>
              ))}
          </ul>

        </div>
        <div className="col-md-6">
          {currentTodo ? (
            <div>
              <h4>Album</h4>
              <div>
                <label>
                  <strong>User ID:</strong>
                </label>{" "}
                {currentTodo.userId}
              </div>
              <div>
                <label>
                  <strong>ID:</strong>
                </label>{" "}
                {currentTodo.id}
              </div>
              <div>
                <label>
                  <strong>Title:</strong>
                </label>{" "}
                {currentTodo.title}
              </div>
            </div>
          ) : (
            <div>
              <br />
              <p>Please click on a Album to see the fields...</p>
            </div>
          )}
        </div>
      </div>
    );
  }
}
