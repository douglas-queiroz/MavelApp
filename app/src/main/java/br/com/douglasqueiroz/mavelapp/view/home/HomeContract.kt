package br.com.douglasqueiroz.mavelapp.view.home

import br.com.douglasqueiroz.mavelapp.model.Character
import br.com.douglasqueiroz.mavelapp.view.ContractBase

interface HomeContract {

    interface View: ContractBase.View {

        fun showList(characters: List<Character>)

        fun showNoDataView()
    }

    interface Presenter: ContractBase.Presenter {

        fun loadData()

        fun searchCharacter(query: String?)

        fun onCharacterListItemClick(character: Character)

        fun loadNextPage(offset: Int)
    }
}