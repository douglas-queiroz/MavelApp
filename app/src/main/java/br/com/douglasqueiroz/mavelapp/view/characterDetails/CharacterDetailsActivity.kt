package br.com.douglasqueiroz.mavelapp.view.characterDetails

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import br.com.douglasqueiroz.mavelapp.R
import br.com.douglasqueiroz.mavelapp.helper.bindView
import br.com.douglasqueiroz.mavelapp.model.Character
import br.com.douglasqueiroz.mavelapp.view.ContractBase
import br.com.douglasqueiroz.mavelapp.view.ViewBase
import com.squareup.picasso.Picasso

class CharacterDetailsActivity : ViewBase(), CharacterDetailsContract.View {

    companion object {
        val CHARACTER_BUNDLE_KEY = "character_bundle_key"
    }

    private val presenter: CharacterDetailsContract.Presenter by lazy { CharacterDetailsPresenter(this, this) }
    private val characterImageView by bindView<ImageView>(R.id.image_view_character_details_character_image)
    private val characterNameTextView by bindView<TextView>(R.id.text_view_character_details_character_name)
    private val characterDescriptionTextView by bindView<TextView>(R.id.text_view_character_details_character_description)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_details)
    }

    override fun getPresenter(): ContractBase.Presenter {
        return presenter
    }

    override fun showCharacter(character: Character) {

        characterNameTextView.text = character.name
        characterDescriptionTextView.text = character.description
        Picasso
            .get()
            .load(character.thumbnail.getFullPath())
            .into(characterImageView)
    }
}